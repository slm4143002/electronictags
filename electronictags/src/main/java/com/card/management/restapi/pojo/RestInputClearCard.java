package com.card.management.restapi.pojo;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
/** UT*/
public class RestInputClearCard {
	// 电子卡片信息
	@NotEmpty(message = "{cardInfoList.notempty}")
	private List<String> cardInfoList;
}
