package com.card.management.restapi.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class BatchNumber {
	// 批量号
	private String batchNumber;
	// 机种名称
	private String machineCategoryName;
	// 台数
	private int machineCount;
	// 车数
	private int carCount;
	// 日期
	private String writeDate;
}
