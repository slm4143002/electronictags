/**
 * 
 */
package com.card.management.restapi;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.card.management.entity.MBatchNumber;
import com.card.management.entity.TAssembleDetail;
import com.card.management.entity.TPreparatoryDetail;
import com.card.management.restapi.ApiResponse.Status;
import com.card.management.restapi.pojo.BatchProccessResult;
import com.card.management.restapi.pojo.ErrorResponse;
import com.card.management.restapi.pojo.RestBatchNumber;
import com.card.management.restapi.pojo.RestCardInfo;
import com.card.management.restapi.pojo.RestInputAssembleCard;
import com.card.management.restapi.pojo.RestInputClearCard;
import com.card.management.restapi.pojo.RestInputGroundConnection;
import com.card.management.restapi.pojo.RestInputPreparatoryCard;
import com.card.management.restapi.pojo.RestInputUt;
import com.card.management.restapi.pojo.RestInputWithstandVoltage;
import com.card.management.service.CardInfoManagementService;

import jakarta.validation.Valid;

/**
 * @author slm
 *
 */
@RestController
@RequestMapping("/card")
public class CardInfoManagementController {

	@Autowired
	public CardInfoManagementService service;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	public BaseStationSendApiService baseStationSendApi;

	// 筹备批量查询
	@GetMapping("/batchnumber")
	public Map<String, Object> getCards(@RequestParam(value = "batchNumber") String batchNumber) {
		try {
			MBatchNumber mbn = service.getCards(batchNumber);
			if (ObjectUtils.isEmpty(mbn)) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1001.getCode(), ErrorCodeConst.MSG1001.getMessage())));
			}
			RestBatchNumber bn = new RestBatchNumber();
			bn.setBatchNumber(mbn.getBatchNumber());
			bn.setCarCount(mbn.getCarCount());
			bn.setMachineCount(mbn.getMachineCount());
			bn.setMachineCategoryName(mbn.getMachineCategoryName());
			// 日期
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			bn.setWriteDate(formatter.format(mbn.getWriteDate()));
			return Map.of("result", ApiResponse.success(Status.SUCCESS, bn));
		} catch (Exception e) {
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG1001.getCode(), ErrorCodeConst.MSG9001.getMessage())));
		}
	}

	// 组装批量查询
	@GetMapping("/assemble-batchnumber")
	public Map<String, Object> getAssembleCards(@RequestParam(value = "batchNumber") String batchNumber) {
		try {
			MBatchNumber mbn = service.getCards(batchNumber);
			if (ObjectUtils.isEmpty(mbn)) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1001.getCode(), ErrorCodeConst.MSG1001.getMessage())));
			}
			RestBatchNumber bn = new RestBatchNumber();
			bn.setBatchNumber(mbn.getBatchNumber());
			bn.setMachineCount(mbn.getMachineCount());
			bn.setMachineCategoryName(mbn.getMachineCategoryName());
			int detailcount = service.getAssembleDetailCount(batchNumber, null);
			if (detailcount == 0) {
				bn.setMachineNum(1);
			} else {
				bn.setMachineNum(detailcount + 1);
			}
			// 日期
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			bn.setWriteDate(formatter.format(mbn.getWriteDate()));
			return Map.of("result", ApiResponse.success(Status.SUCCESS, bn));
		} catch (Exception e) {
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG1001.getCode(), ErrorCodeConst.MSG9001.getMessage())));
		}
	}

	/** 
	 * 登录信息(批量和筹备)
	 *
	 *
	 */
	@PostMapping("/preparatory-detail")
	public Map<String, Object> createPreparatory(@Valid @RequestBody RestInputPreparatoryCard restInputPreparatoryCard,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				List<ObjectError> listError = bindingResult.getAllErrors();
				StringBuilder sb = new StringBuilder();
				listError.forEach(error -> {
					sb.append(error.getDefaultMessage());
					sb.append("/");
				});
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1003.getCode(), sb.toString())));
			}
			long detailcount = service.getPreparatoryDetailCount(restInputPreparatoryCard.getBatchNumber());
			if (detailcount > 0) {
				String batchNumberInsertMessage = messageSource.getMessage("batchNumberInsertMessage",
						new String[] { restInputPreparatoryCard.getBatchNumber() }, Locale.CHINA);

				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1002.getCode(), batchNumberInsertMessage)));
			}
			// 日期
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date writeDate = formatter.parse(restInputPreparatoryCard.getWriteDate());

			// 筹备信息取得
			List<RestCardInfo> cardInfo = restInputPreparatoryCard.getCardInfoList();
			List<TPreparatoryDetail> preparatoryDetailInfoList = new ArrayList<>();
			cardInfo.forEach(card -> {
				TPreparatoryDetail entity = new TPreparatoryDetail();
				// 电子卡绑定信息
				entity.setCardBindingNumber(card.getCardInfo());
				// 车数
				entity.setCarTimes(Integer.parseInt(card.getCardCount()));
				// 批量号
				entity.setBatchNumber(restInputPreparatoryCard.getBatchNumber());
				entity.setCheckResult("1");
				entity.setWriteDate(writeDate);
				preparatoryDetailInfoList.add(entity);
			});

			service.createBatchNumberPreparatoryDetail(preparatoryDetailInfoList);

			return Map.of("result", ApiResponse.success(Status.SUCCESS,
					new ErrorResponse(ErrorCodeConst.MSG6001.getCode(), ErrorCodeConst.MSG6001.getMessage())));

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG9001.getCode(), sw.toString())));
		}

	}

	/** 
	 * 登录信息(批量和组装)
	 *
	 *
	 */
	@PostMapping("/assemble-detail")
	public Map<String, Object> createAssemble(@Valid @RequestBody RestInputAssembleCard restInputAssembleCard,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				List<ObjectError> listError = bindingResult.getAllErrors();
				StringBuilder sb = new StringBuilder();
				listError.forEach(error -> {
					sb.append(error.getDefaultMessage());
					sb.append("/");
				});
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1003.getCode(), sb.toString())));
			}
			// 组装信息取得
			RestCardInfo cardInfo = restInputAssembleCard.getRestCardInfo();

			// 组装登录check
			int detailcount = service.getAssembleDetailCount(restInputAssembleCard.getBatchNumber(),
					cardInfo.getCardInfo());
			if (detailcount > 0) {
				String batchNumberInsertMessage = messageSource.getMessage("batchNumberInsertMessage",
						new String[] { restInputAssembleCard.getBatchNumber() }, Locale.CHINA);

				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1002.getCode(), batchNumberInsertMessage)));
			}

			// 基站推送
			String response = baseStationSendApi.postRequest(restInputAssembleCard, TemplateEnum.ASSEMBLE);
			// 基站错误
			if ("1".equals(response)) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG9002.getCode(), ErrorCodeConst.MSG9002.getMessage())));
			}

			MBatchNumber mbn = service.getCards(restInputAssembleCard.getBatchNumber());

			TAssembleDetail entity = new TAssembleDetail();
			// 批量号
			entity.setBatchNumber(restInputAssembleCard.getBatchNumber());
			// 台数
			entity.setPieceTimes(Integer.parseInt(cardInfo.getCardCount()));
			// 日期
			entity.setWriteDate(mbn.getWriteDate());
			// 组装OK
			entity.setAssembleResult("1");
			entity.setUpdateDate(new Date());
			entity.setCreateDate(new Date());
			// 电子卡绑定信息
			entity.setCardBindingNumber(cardInfo.getCardInfo());

			//service.createAssemblDdetail(entity);

			return Map.of("result", ApiResponse.success(Status.SUCCESS,
					new ErrorResponse(ErrorCodeConst.MSG6001.getCode(), ErrorCodeConst.MSG6001.getMessage())));

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG9001.getCode(), sw.toString())));
		}

	}

	/** 
	 * 接地工位更新
	 *
	 *
	 */
	@PostMapping("/ground-connection")
	public Map<String, Object> updateGroundConnection(
			@Valid @RequestBody RestInputGroundConnection restInputGroundConnection,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				List<ObjectError> listError = bindingResult.getAllErrors();
				StringBuilder sb = new StringBuilder();
				listError.forEach(error -> {
					sb.append(error.getDefaultMessage());
					sb.append("/");
				});
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1003.getCode(), sb.toString())));
			}

			List<TAssembleDetail> list = service.getBatchNumberBybingNumber(restInputGroundConnection.getCardInfo());
			if (CollectionUtils.isEmpty(list)) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1006.getCode(), ErrorCodeConst.MSG1006.getMessage())));
			}
			TAssembleDetail tadl = list.get(0);
			// check前面工序是否完成
			if (!"1".equals(tadl.getAssembleResult())) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1006.getCode(), ErrorCodeConst.MSG1006.getMessage())));
			}

			TAssembleDetail tad = new TAssembleDetail();
			tad.setCardBindingNumber(restInputGroundConnection.getCardInfo());
			tad.setGroundConnectionResult(restInputGroundConnection.getCheckResult());
			service.updateAssemblDdetail(tad);

			return Map.of("result", ApiResponse.success(Status.SUCCESS,
					new ErrorResponse(ErrorCodeConst.MSG6001.getCode(), ErrorCodeConst.MSG6001.getMessage())));

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG9001.getCode(), sw.toString())));
		}

	}

	/** 
	 * 耐压更新
	 *
	 *
	 */
	@PostMapping("/withstand-voltage")
	public Map<String, Object> updateWithstandVoltage(
			@Valid @RequestBody RestInputWithstandVoltage restInputWithstandVoltage,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				List<ObjectError> listError = bindingResult.getAllErrors();
				StringBuilder sb = new StringBuilder();
				listError.forEach(error -> {
					sb.append(error.getDefaultMessage());
					sb.append("/");
				});
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1003.getCode(), sb.toString())));
			}

			List<TAssembleDetail> list = service.getBatchNumberBybingNumber(restInputWithstandVoltage.getCardInfo());
			if (CollectionUtils.isEmpty(list)) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1006.getCode(), ErrorCodeConst.MSG1006.getMessage())));
			}
			TAssembleDetail tadl = list.get(0);
			// check前面工序是否完成
			if (!"1".equals(tadl.getAssembleResult())) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1006.getCode(), ErrorCodeConst.MSG1006.getMessage())));
			} else if (!"1".equals(tadl.getGroundConnectionResult())) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1005.getCode(), ErrorCodeConst.MSG1005.getMessage())));
			}

			TAssembleDetail tad = new TAssembleDetail();
			tad.setCardBindingNumber(restInputWithstandVoltage.getCardInfo());
			tad.setWithstandVoltageResult(restInputWithstandVoltage.getCheckResult());
			service.updateAssemblDdetail(tad);

			return Map.of("result", ApiResponse.success(Status.SUCCESS,
					new ErrorResponse(ErrorCodeConst.MSG6001.getCode(), ErrorCodeConst.MSG6001.getMessage())));

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG9001.getCode(), sw.toString())));
		}

	}

	/** 
	 * UT更新
	 *
	 *
	 */
	@PostMapping("/ut")
	public Map<String, Object> updateUt(@Valid @RequestBody RestInputUt restInputUt,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				List<ObjectError> listError = bindingResult.getAllErrors();
				StringBuilder sb = new StringBuilder();
				listError.forEach(error -> {
					sb.append(error.getDefaultMessage());
					sb.append("/");
				});
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1003.getCode(), sb.toString())));
			}
			List<TAssembleDetail> list = service.getBatchNumberBybingNumber(restInputUt.getCardInfo());
			if (CollectionUtils.isEmpty(list)) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1006.getCode(), ErrorCodeConst.MSG1006.getMessage())));
			}
			TAssembleDetail tadl = list.get(0);
			// check前面工序是否完成
			if (!"1".equals(tadl.getAssembleResult())) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1006.getCode(), ErrorCodeConst.MSG1006.getMessage())));
			} else if (!"1".equals(tadl.getGroundConnectionResult())) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1005.getCode(), ErrorCodeConst.MSG1005.getMessage())));
			} else if (!"1".equals(tadl.getWithstandVoltageResult())) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1004.getCode(), ErrorCodeConst.MSG1004.getMessage())));
			}

			TAssembleDetail tad = new TAssembleDetail();
			tad.setCardBindingNumber(restInputUt.getCardInfo());
			tad.setUtResult(restInputUt.getCheckResult());
			tad.setTicketInfo(restInputUt.getTicketInfo());
			service.updateAssemblDdetail(tad);

			if ("1".equals(restInputUt.getCheckResult())) {
				BatchProccessResult bp = new BatchProccessResult();
				bp.setBatchNumber(tadl.getBatchNumber());
				return Map.of("result", ApiResponse.success(Status.SUCCESS, bp));
			} else {
				return Map.of("result", ApiResponse.success(Status.SUCCESS, null));
			}

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG9001.getCode(), sw.toString())));
		}

	}

	/** 
	 * 电子卡片清除更新
	 *
	 *
	 */
	@PostMapping("/clear-card")
	public Map<String, Object> clearCard(@Valid @RequestBody RestInputClearCard restInputClearCard,
			BindingResult bindingResult) {
		try {
			if (bindingResult.hasErrors()) {
				List<ObjectError> listError = bindingResult.getAllErrors();
				StringBuilder sb = new StringBuilder();
				listError.forEach(error -> {
					sb.append(error.getDefaultMessage());
					sb.append("/");
				});
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1003.getCode(), sb.toString())));
			}

			service.clearAssembleDetail(restInputClearCard.getCardInfoList());

			return Map.of("result", ApiResponse.success(Status.SUCCESS,
					new ErrorResponse(ErrorCodeConst.MSG6001.getCode(), ErrorCodeConst.MSG6001.getMessage())));

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG9001.getCode(), sw.toString())));
		}

	}
}
