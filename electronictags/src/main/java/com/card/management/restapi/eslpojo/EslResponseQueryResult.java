package com.card.management.restapi.eslpojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/* 基站返回值 **/
public class EslResponseQueryResult {
	public String esl_code;
	public int action;
}
