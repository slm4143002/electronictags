package com.card.management.restapi.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
/** 耐压*/
public class RestInputGroundConnection {
	// 电子卡片信息
	private String cardInfo;
	// check结果
	private String checkResult;
	// 电子卡片捆绑唯一标识
	private String cardBindingUnique;
}
