package com.card.management.restapi.eslpojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 组装模板*/
@Getter
@Setter
@NoArgsConstructor
public class ProductAssembleTemplate extends ProductTemplate {
	// 组装结果
	public String p1;
	// 接地结果
	public String p2;
	// 接地结果
	public String p3;
	// UT结果
	public String p4;
}
