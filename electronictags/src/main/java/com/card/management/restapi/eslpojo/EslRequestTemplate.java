package com.card.management.restapi.eslpojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EslRequestTemplate {

	// ⻔店编码
	public String store_code;
	// 直接刷屏数据数组
	public F1Template f1;
	// 默认为0
	public String is_base64;
	// 令牌
	public String sign;

}
