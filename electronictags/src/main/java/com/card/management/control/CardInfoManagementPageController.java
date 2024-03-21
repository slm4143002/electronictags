/**
 * 
 */
package com.card.management.control;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import com.card.management.entity.AssembleDetailEntity;
import com.card.management.entity.MBatchNumber;
import com.card.management.entity.PreparatoryDetailEntity;
import com.card.management.entity.TLoGradeHistory;
import com.card.management.entity.TPreparatoryDetail;
import com.card.management.entity.TWarningMessage;
import com.card.management.restapi.BaseStationSendApiService;
import com.card.management.restapi.ErrorCodeConst;
import com.card.management.restapi.TemplateEnum;
import com.card.management.restapi.pojo.RestCardInfo;
import com.card.management.restapi.pojo.RestInputClearCard;
import com.card.management.restapi.pojo.RestInputPreparatoryCard;
import com.card.management.service.CardInfoManagementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.validation.Valid;

/**
 * @author slm
 *
 */
@Controller
public class CardInfoManagementPageController implements WebMvcConfigurer {

	@Autowired
	public CardInfoManagementService service;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	public BaseStationSendApiService baseStationSendApi;

	/**
	 * login画面
	 * @return
	 */
	@GetMapping("/login")
	public String getCards() {
		return "navigation";
	}

	/**
	 * 跳转到筹备电子卡片登录画面
	 * @param cardview
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@GetMapping("/gotoCardview")
	public String creadCard(CardView cardView, Model model) {
		List<TWarningMessage> wmList = service.getWaringMessage();
		CardView card = new CardView();
		card.setWarningMessageList(wmList);
		model.addAttribute("cardView", card);
		return "cardview";
	}

	/**
	 * 跳转到清除电子卡片页
	 * @param cardview
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@GetMapping("/gotoClearCardView")
	public String gotoClearCardView(Model model) {
		model.addAttribute("cardView", new CardClearView());
		return "clearcard";
	}

	/**
	 * 批量号信息查询
	 * @param cardview
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/searchCardInfo")
	public ResponseEntity<Object> searchCardInfo(@Valid CardView cardview,
			BindingResult result,
			Model model) {
		MBatchNumber batchNumber = service.getCards(cardview.getBatchNumber());
		if (batchNumber == null) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}
		CardView card = new CardView();
		card.setBatchNumber(batchNumber.getBatchNumber());
		card.setCarCount(StringUtils.toString(batchNumber.getCarCount()));
		card.setMachineCategoryName(batchNumber.getMachineCategoryName());
		card.setMachineCount(StringUtils.toString(batchNumber.getMachineCount()));
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		card.setWriteDate(formatter.format(batchNumber.getWriteDate()));
		return new ResponseEntity<Object>(card, HttpStatus.OK);
	}

	/** 
	 * 登录信息(批量和筹备)
	 *
	 *
	 */
	@PostMapping("/createCardInfo")
	public String createCardInfo(@Valid CardView cardView, BindingResult bindingResult, Model model) {
		try {
			if (bindingResult.hasErrors()) {
				return "cardview";
			}
			long detailcount = service.getPreparatoryDetailCount(cardView.getBatchNumber());
			if (detailcount > 0) {
				String batchNumberInsertMessage = messageSource.getMessage("batchNumberInsertMessage",
						new String[] { cardView.getBatchNumber() }, Locale.CHINA);
				ObjectError error = new ObjectError("batchNumber", batchNumberInsertMessage);
				bindingResult.addError(error);
				return "cardview";
			}

			// 基站推送
			List<String> f3List = new ArrayList<String>();
			RestInputPreparatoryCard restInputPreparatoryCard = new RestInputPreparatoryCard();
			List<RestCardInfo> cardInfoList = new ArrayList<RestCardInfo>();
			restInputPreparatoryCard.setBatchNumber(cardView.getBatchNumber());
			restInputPreparatoryCard.setMachineCategoryName(cardView.getMachineCategoryName());
			restInputPreparatoryCard.setCarCount(cardView.getCarCount());
			restInputPreparatoryCard.setMachineCount(cardView.getMachineCount());
			restInputPreparatoryCard.setWriteDate(cardView.getWriteDate());
			cardView.getCardInfoList().forEach(cinfo -> {
				RestCardInfo restCardInfo = new RestCardInfo();
				restCardInfo.setCardCount(cinfo.getCardCount());
				restCardInfo.setCardInfo(cinfo.getCardInfo());
				cardInfoList.add(restCardInfo);
				f3List.add(cinfo.getCardInfo());
			});
			restInputPreparatoryCard.setCardInfoList(cardInfoList);
			
			// check水墨屏是否被使用
			List<PreparatoryDetailEntity> list1 = service.checkPreparatoryBinNumber(f3List);
			List<AssembleDetailEntity> list2=  service.checkAssembleBinNumber(f3List);
			StringBuilder sb0=new StringBuilder();
			if (CollectionUtils.isEmpty(list1) && CollectionUtils.isEmpty(list2)) {
			} else {
				if (!CollectionUtils.isEmpty(list1)) {
					for (int i=0;i<list1.size();i++) {
						sb0.append(list1.get(i).getCardBindingNumber());
						sb0.append("/");
					}
				}
				if (!CollectionUtils.isEmpty(list2)) {
					for (int i=0;i<list2.size();i++) {
						sb0.append(list2.get(i).getCardBindingNumber());
						sb0.append("/");
					}
				}
				
				String eslErrorMessage = ErrorCodeConst.MSG1007.getMessage();
				ObjectError error = new ObjectError("batchNumber", sb0.toString() +  eslErrorMessage);
				bindingResult.addError(error);
				return "cardview";
			}
			
//			String response = baseStationSendApi.postRequest(restInputPreparatoryCard, TemplateEnum.PREPARATORY);
//			// 基站错误
//			if ("1".equals(response)) {
//				String eslErrorMessage = ErrorCodeConst.MSG9002.getMessage();
//				ObjectError error = new ObjectError("batchNumber", eslErrorMessage);
//				bindingResult.addError(error);
//				return "cardview";
//			}
//			// 拉取基站水墨屏信息
//			boolean isOver = true;
//			List<java.util.LinkedHashMap> eqList = new ArrayList<java.util.LinkedHashMap>();
//			while (isOver) {
//				isOver = false;
//				eqList = baseStationSendApi.getEslResult(f3List);
//				if (CollectionUtils.isEmpty(eqList)) {
//					ObjectError error = new ObjectError("batchNumber", ErrorCodeConst.MSG9002.getMessage());
//					bindingResult.addError(error);
//					return "cardview";
//				}
//				for (int i = 0; i < eqList.size(); i++) {
//					if ((Integer) eqList.get(i).get("action") != 0 && (Integer) eqList.get(i).get("action") != 200) {
//						isOver = true;
//					}
//				}
//				Thread.sleep(500);
//
//			}
//			StringBuilder sb = new StringBuilder();
//			for (int i = 0; i < eqList.size(); i++) {
//				if ((Integer) eqList.get(i).get("action") != 0) {
//					sb.append(eqList.get(i).get("esl_code"));
//					sb.append("/");
//				}
//			}
//
//			if (sb.length() != 0) {
//				ObjectError error = new ObjectError("batchNumber", sb.toString() + ErrorCodeConst.MSG9002.getMessage());
//				bindingResult.addError(error);
//				return "cardview";
//			}

			// 日期
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date writeDate = formatter.parse(cardView.getWriteDate());

			// 筹备信息取得
			List<CardInfo> cardInfo = cardView.getCardInfoList();
			List<TPreparatoryDetail> preparatoryDetailInfoList = new ArrayList<>();
			for(int k=0;k<cardInfo.size();k++) {
				TPreparatoryDetail entity = new TPreparatoryDetail();
				if (StringUtils.isEmpty(cardInfo.get(k).getCardInfo()) && StringUtils.isEmpty(cardInfo.get(k).getCardCount())) {
					continue;
				} else if (StringUtils.isEmpty(cardInfo.get(k).getCardInfo()) || StringUtils.isEmpty(cardInfo.get(k).getCardCount())) {
					ObjectError error = new ObjectError("batchNumber", ErrorCodeConst.MSG1008.getMessage());
					bindingResult.addError(error);
					return "cardview";
				}
				// 电子卡绑定信息
				entity.setCardBindingNumber(cardInfo.get(k).getCardInfo());
				// 车数
				entity.setCarTimes(Integer.parseInt(parseCarCount(cardInfo.get(k).getCardCount())));
				// 批量号
				entity.setBatchNumber(cardView.getBatchNumber());
				entity.setCheckResult("1");
				entity.setWriteDate(writeDate);
				preparatoryDetailInfoList.add(entity);
			}

			service.createBatchNumberPreparatoryDetail(preparatoryDetailInfoList);
		} catch (Exception e) {
			e.printStackTrace();
			return "cardview";
		}
		CardView card = new CardView();
		String infoMessage = messageSource.getMessage("cardInfoFinshied", new String[] { cardView.getBatchNumber() },
				Locale.CHINA);
		card.setInfoMessage(infoMessage);
		model.addAttribute("cardView", card);

		return "cardview";
	}

	/**
	 * 1/5 
	 * @param card
	 * @return
	 */
	private String parseCarCount(String card) {
		String[] cardArray = new String[2];
		cardArray = card.split("/");
		return cardArray[0];
	}

	/*********************筹备明细***********************************************************/
	/** 
	 * 跳转到筹备明细 
	 * 
	 */
	@GetMapping("/preparatoryDetail")
	public String preparatoryDetail() {

		return "preparator-detail-list";
	}

	@PostMapping("/preparatoryDetailResult")
	public ResponseEntity<Pages<PreparatoryDetailEntity>> preparatoryDetailResult(@RequestParam int pageNumber,
			String pageSize) {
		String regex = "\\d*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pageSize);

		if (matcher.matches()) {
			PageHelper.startPage(pageNumber, Integer.valueOf(pageSize));
		} else {
			PageHelper.startPage(1, service.getPreparatoryDetailCount(null));
		}

		List<PreparatoryDetailEntity> all = service.getPreparatoryDetailBybatchNumber(null);
		PageInfo<PreparatoryDetailEntity> pageInfo = new PageInfo<PreparatoryDetailEntity>(all);
		Pages<PreparatoryDetailEntity> pages = new Pages<PreparatoryDetailEntity>();
		pages.setRows(all);
		pages.setTotal((int) pageInfo.getTotal());
		return new ResponseEntity<Pages<PreparatoryDetailEntity>>(pages, HttpStatus.OK);
	}

	/*********************************:*********************组装明细***********************************************************/
	/** 
	 * 跳转到组装明细
	 * 
	 */
	@GetMapping("/assembleDetail")
	public String assembleDetail() {

		return "assemble-detail-list";
	}

	@PostMapping("/assembleDetailResult")
	public ResponseEntity<Pages<AssembleDetailEntity>> assembleDetailResult(@RequestParam int pageNumber,
			String pageSize) {
		String regex = "\\d*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pageSize);

		if (matcher.matches()) {
			PageHelper.startPage(pageNumber, Integer.valueOf(pageSize));
		} else {
			PageHelper.startPage(1, service.getAssembleDetailCount(null, null));
		}

		List<AssembleDetailEntity> all = service.getAssembleDetailBybatchNumber(null);
		PageInfo<AssembleDetailEntity> pageInfo = new PageInfo<AssembleDetailEntity>(all);
		Pages<AssembleDetailEntity> pages = new Pages<AssembleDetailEntity>();
		pages.setRows(all);
		pages.setTotal((int) pageInfo.getTotal());
		return new ResponseEntity<Pages<AssembleDetailEntity>>(pages, HttpStatus.OK);
	}

	/*********************************:*********************L/O品一览***********************************************************/
	/** 
	 * 跳转到L/O品一览
	 * 
	 */
	@GetMapping("/loGradeHistory")
	public String loGradeHistory() {

		return "lo-grade-history";
	}

	@PostMapping("/loGradeHistoryResult")
	public ResponseEntity<Pages<TLoGradeHistory>> loGradeHistoryResult(@RequestParam int pageNumber, String pageSize) {
		String regex = "\\d*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pageSize);

		if (matcher.matches()) {
			PageHelper.startPage(pageNumber, Integer.valueOf(pageSize));
		} else {
			PageHelper.startPage(1, service.getLoGradeHistoryCount());
		}

		List<TLoGradeHistory> all = service.getLoGradeHistory();
		PageInfo<TLoGradeHistory> pageInfo = new PageInfo<TLoGradeHistory>(all);
		Pages<TLoGradeHistory> pages = new Pages<TLoGradeHistory>();
		pages.setRows(all);
		pages.setTotal((int) pageInfo.getTotal());
		return new ResponseEntity<Pages<TLoGradeHistory>>(pages, HttpStatus.OK);
	}

	/** 
	 * 卡片清除
	 *
	 *
	 */
	@PostMapping("/clearCardInfo")
	public String clearCardInfo(@Valid @ModelAttribute("cardView") CardClearView cardView, BindingResult bindingResult,
			Model model) {
		try {
			if (bindingResult.hasErrors()) {
				return "clearcard";
			}

			// 基站推送
			List<String> f3List = new ArrayList<String>();
			RestInputClearCard restInputClearCard = new RestInputClearCard();
			List<String> cardInfoList = new ArrayList<String>();
			cardView.getCardInfoList().forEach(cinfo -> {
				if (!StringUtils.isEmptyOrWhitespace(cinfo.getCardInfo())) {
					cardInfoList.add(StringUtils.trim(cinfo.getCardInfo()));
					f3List.add(cinfo.getCardInfo());
				}
			});
			restInputClearCard.setCardInfoList(cardInfoList);
			 String response = baseStationSendApi.postRequest(restInputClearCard, TemplateEnum.CLEAR);
			// 基站错误
			if ("1".equals(response)) {
				String eslErrorMessage = ErrorCodeConst.MSG9002.getMessage();
				ObjectError error = new ObjectError("cardInfoList[0].cardInfo", eslErrorMessage);
				bindingResult.addError(error);
				return "clearcard";
			}
			// 拉取基站水墨屏信息
			boolean isOver = true;
			List<java.util.LinkedHashMap> eqList = new ArrayList<java.util.LinkedHashMap>();

			while (isOver) {
				isOver = false;
				eqList = baseStationSendApi.getEslResult(f3List);
				if (CollectionUtils.isEmpty(eqList)) {
					ObjectError error = new ObjectError("infoMessage", ErrorCodeConst.MSG9002.getMessage());
					bindingResult.addError(error);
					return "clearcard";
				}
				for (int i = 0; i < eqList.size(); i++) {
					if ((Integer) eqList.get(i).get("action") != 0 && (Integer) eqList.get(i).get("action") != 200) {
						isOver = true;
					}
				}
				Thread.sleep(500);

			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < eqList.size(); i++) {
				if ((Integer) eqList.get(i).get("action") != 0) {
					sb.append(eqList.get(i).get("esl_code"));
					sb.append("/");
				}
			}

			if (sb.length() != 0) {
				ObjectError error = new ObjectError("infoMessage", sb.toString() + ErrorCodeConst.MSG9002.getMessage());
				bindingResult.addError(error);
				return "clearcard";
			}

			// 解绑卡片更新
			// 组装解除
			service.clearAssembleDetail(f3List);
			// 筹备解除
			service.clearPreparatoryDetail(f3List);

		} catch (Exception e) {
			e.printStackTrace();
			return "clearcard";
		}
		CardClearView card = new CardClearView();
		String infoMessage = messageSource.getMessage("clearCardMessage", null,
				Locale.CHINA);
		card.setInfoMessage(infoMessage);
		model.addAttribute("cardView", card);

		return "clearcard";
	}
}
