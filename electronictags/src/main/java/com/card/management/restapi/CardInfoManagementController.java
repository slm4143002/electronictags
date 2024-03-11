/**
 * 
 */
package com.card.management.restapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.card.management.entity.MBatchNumber;
import com.card.management.restapi.ApiResponse.Status;
import com.card.management.restapi.pojo.BatchNumber;
import com.card.management.restapi.pojo.ErrorResponse;
import com.card.management.service.CardInfoManagementService;

/**
 * @author slm
 *
 */
@RestController
@RequestMapping("/card")
public class CardInfoManagementController {

	@Autowired
	public CardInfoManagementService service;

	// 批量号
	@GetMapping("/batchnumber")
	public Map<String, Object> getCards(@RequestParam(value = "batchNumber") String batchNumber) {
		try {
			MBatchNumber mbn = service.getCards(batchNumber);
			if (ObjectUtils.isEmpty(mbn)) {
				return Map.of("result", ApiResponse.error(Status.ERROR,
						new ErrorResponse(ErrorCodeConst.MSG1001.getCode(), ErrorCodeConst.MSG1001.getMessage())));
			}
			BatchNumber bn = new BatchNumber();
			bn.setBatchNumber(mbn.getBatchNumber());
			bn.setCarCount(mbn.getCarCount());
			bn.setMachineCount(mbn.getMachineCount());
			bn.setMachineCategoryName(mbn.getMachineCategoryName());
			// 日期
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			bn.setWriteDate(formatter.format(mbn.getWriteDate()));
			return Map.of("result", ApiResponse.success(Status.SUCCESS, bn));
		} catch(Exception e) {
			return Map.of("result", ApiResponse.error(Status.ERROR,
					new ErrorResponse(ErrorCodeConst.MSG1001.getCode(), ErrorCodeConst.MSG9001.getMessage())));
		}
	}

}
