package com.card.management.restapi.pojo;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
/** 接地 */
public class RestInputGroundConnection {
	// 电子卡片信息
	@NotBlank
	private String cardInfo;
	// check结果
	@NotBlank
	private String checkResult;
}
