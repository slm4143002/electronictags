package com.card.management.restapi.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RestInputAssembleCard extends RestInputCard{

	@NotBlank(message = "{batchNumber.notBlank}")
	private String batchNumber;
	private String machineCategoryName;
	// 台数
	@NotBlank(message = "{machineCount.notBlank}")
	private String machineCount;
	@NotNull(message = "{restCardInfo.notempty}")
	private RestCardInfo  restCardInfo;
	
	// 组装结果
	private String assembleResult;
	// 接地结果
	private String groundConnectionResult;
	// 耐压结果
	private String withstandVoltageResult;
	// UT结果
	private String utResult;

}
