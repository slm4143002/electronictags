package com.card.management.restapi.pojo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
/** UT*/
public class RestOutputClearCard {
	// 电子卡片信息
	private List<RestCardInfo> cardInfoList;
}
