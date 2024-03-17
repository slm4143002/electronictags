package com.card.management.restapi.eslpojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class F1Template {
	// 水墨屏ID 电子卡片信息
	public String esl_code;
	// 水墨屏模板ID
	public String template_id;
	public Product product;

}
