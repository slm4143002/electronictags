package com.card.management.restapi;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BaseStationRestTemplate {
    
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(10000); // 设置连接超时时间
		factory.setReadTimeout(10000); // 设置读取超时时间
		RestTemplate rt = new RestTemplate();
		rt.setErrorHandler(new EslResponseErrorHandler());
		rt.setRequestFactory(factory);
		return rt;
	}

}
