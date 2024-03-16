package com.card.management.restapi.eslpojo;

import com.card.management.restapi.pojo.RestResponseResult;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/* 基站返回值 **/
public class EslResponseResult {
	public RestResponseResult result;
	public String error_code;
	public String error_msg;
}
