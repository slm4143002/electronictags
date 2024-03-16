package com.card.management.restapi.eslpojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductTemplate {
	// 水墨屏ID 电子卡片信息
	public String esl_code;
	// 水墨屏模板ID
	public String template_id;
	// 批量号
	public String pc;
	// 电子卡信息
	public String pn;
	// 台数或车数
	public String pp;
	// 日期
	public String pd;
}
