package com.card.management.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class AssembleDetailEntity {
	private String batchNumber;
	private String ticketInfo;
	private String machineCategoryName;
	private String machineCount;
	private String writeDate;
	/** 组装结果 */
	private String assembleResult;
	/** 接地结果 */
	private String groundConnectionResult;
	/** 耐压结果 */
	private String withstandVoltageResult;
	/** UT结果 */
	private String utResult;
	/** 本批量结果 */
	private String checkResult;
	/** 电子卡片捆绑信息 */
	private String cardBindingNumber;
}
