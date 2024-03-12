package com.card.management.restapi.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
/** 接地*/
public class RestInputWithstandVoltage {
	// 电子卡片信息
	private String cardInfo;
	// check结果
	private String checkResult;
	// 电子卡片捆绑显示
	private String cardInfoDetail;
}
