package com.card.management.restapi.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
/** UT*/
public class RestInputUt {
	// 电子卡片信息
	private String cardInfo;
	// check结果
	private String checkResult;
	// 小票内容显示
	private String ticketInfo;
	// 电子卡片捆绑显示
	private String cardInfoDetail;
}
