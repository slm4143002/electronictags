package com.card.management.restapi.eslpojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Product {
	// 机种名称
	public String f1;
	
	// 台数(组装结果)
	public String f2;
	
	// 当前车数(接地结果)
	public String f3;
	
	// 批量号(耐压结果)
	public String f4;
	
	// 日期(UT结果)
	public String f5;
	
	// 组装批量号
	public String f6;
	
	// 组装当前台数
	public String f7;
}
