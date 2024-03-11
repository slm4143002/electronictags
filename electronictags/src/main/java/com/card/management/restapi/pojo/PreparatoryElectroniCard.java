/**
 * 
 */
package com.card.management.restapi.pojo;

import java.util.List;

import com.card.management.control.CardInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author slm
 * 筹备电子卡片json对象
 */
@Getter @Setter @NoArgsConstructor
public class PreparatoryElectroniCard {
	// 批量号
	private String batchNumber;
	// 机种名称
	private String machineCategoryName;
	// 台数
	private String machineCount;
	// 车数
	private String carCount;
	// 日期
	private String writeDate;
	// 筹备电子卡信息
	private List<CardInfo>  cardInfoList;

}
