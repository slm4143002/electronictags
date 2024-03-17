package com.card.management.restapi.eslpojo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EslRequestQueryTemplate {

	// ⻔店编码
	public String store_code;
	// 默认为0
	public String is_base64;
	// 令牌
	public String sign;
	// f1
	public int f1;
	// f2
	public int f2;
	// f3(水墨屏id数组)
	public List<String> f3;
}
