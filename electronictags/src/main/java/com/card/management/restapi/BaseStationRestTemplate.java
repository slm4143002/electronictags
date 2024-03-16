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
		factory.setConnectTimeout(5000); // 设置连接超时时间
		factory.setReadTimeout(5000); // 设置读取超时时间
		RestTemplate rt = new RestTemplate();
		rt.setRequestFactory(factory);
		return rt;
	}

}
