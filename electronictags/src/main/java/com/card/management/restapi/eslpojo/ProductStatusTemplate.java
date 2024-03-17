package com.card.management.restapi.eslpojo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 水墨屏状态模板*/
@Getter
@Setter
@NoArgsConstructor
public class ProductStatusTemplate extends ProductTemplate  {
	// 日期
	public String pc;
	// f1
	public String f1;
	// f2
	public String f2;
	// f3(水墨屏id数组)
	public List<String> f3;
}
