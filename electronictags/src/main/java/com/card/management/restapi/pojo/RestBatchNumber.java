package com.card.management.restapi.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RestBatchNumber {
	// 批量号
	private String batchNumber;
	// 机种名称
	private String machineCategoryName;
	// 总台数
	private int machineCount;
	// 现在使用台数
	private int machineNum;
	// 车数
	private int carCount;
	// 日期
	private String writeDate;
}
