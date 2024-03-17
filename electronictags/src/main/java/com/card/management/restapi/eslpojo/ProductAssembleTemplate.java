package com.card.management.restapi.eslpojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 组装模板*/
@Getter
@Setter
@NoArgsConstructor
public class ProductAssembleTemplate extends ProductTemplate {
	// 机种名称
	public String f1;
	// 组装结果
	public String f2;
	// 接地结果
	public String f3;
	// 耐压结果
	public String f4;
	// UT结果
	public String f5;
	// 批量号
	public String f6;
	// 当前台数
	public String f7;
}
