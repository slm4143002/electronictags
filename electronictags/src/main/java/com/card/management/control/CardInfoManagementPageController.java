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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.card.management.entity.AssembleDetailEntity;
import com.card.management.entity.MBatchNumber;
import com.card.management.entity.PreparatoryDetailEntity;
import com.card.management.entity.TLoGradeHistory;
import com.card.management.entity.TPreparatoryDetail;
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
	
	/**
	 * login画面
	 * @return
	 */
	@GetMapping("/login")
	public String getCards() {
		return "navigation";
	}

	@GetMapping("/gotoCrdview")
	public String showForm(CardView cardView) {
		return "cardview";
	}
	
	/**
	 * 跳转到筹备电子卡片登录画面
	 * @param cardview
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@GetMapping("/gotoCrdview1")
	public String creadCard(CardView cardView) {
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
		model.addAttribute("cardview", new CardView());
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
	public ResponseEntity<Object> searchCardInfo(@Valid @ModelAttribute("cardview") CardView cardview,
			BindingResult result,
			Model model) {
		MBatchNumber batchNumber = service.getCards(cardview.getBatchNumber());
		if (batchNumber == null) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Object>(batchNumber, HttpStatus.OK);
	}

	/** 
	 * 登录信息(批量和筹备)
	 *
	 *
	 */
	@PostMapping("/createCardInfo")
	public String createCardInfo(@Valid CardView cardview,BindingResult bindingResult,Model model) {
		try {
		
			if (bindingResult.hasErrors()) {
				model.addAttribute("cardview", cardview);
				return "cardview";
			}
			
			// 日期
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date writeDate = formatter.parse(cardview.getWriteDate());

			// 筹备信息取得
			List<CardInfo> cardInfo = cardview.getCardInfoList();
			List<TPreparatoryDetail> preparatoryDetailInfoList = new ArrayList<>();
			cardInfo.forEach(card -> {
				TPreparatoryDetail entity = new TPreparatoryDetail();
				// 电子卡绑定信息
				entity.setCardBindingNumber(card.getCardInfo());
				// 车数
				entity.setCarTimes(Integer.parseInt(parseCarCount(card.getCardCount())));
				// 批量号
				entity.setBatchNumber(cardview.getBatchNumber());
				entity.setCheckResult("1");
				entity.setWriteDate(writeDate);
				preparatoryDetailInfoList.add(entity);
			});

			service.createBatchNumberPreparatoryDetail(preparatoryDetailInfoList);
		} catch (Exception e) {
			model.addAttribute("cardview", cardview);
			return "cardview";
		}
		CardView card = new CardView();
		String infoMessage = messageSource.getMessage("cardInfoFinshied", new String[]{cardview.getBatchNumber()}, Locale.CHINA);
		card.setInfoMessage(infoMessage);
		model.addAttribute("cardview", card);

		return "cardview";
	}

	/**
	 * 1/5 
	 * @param card
	 * @return
	 */
	private String parseCarCount(String card) {
		String[] cardArray = card.split("/");
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
			PageHelper.startPage(1, service.getAssembleDetailCount(null));
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
}
