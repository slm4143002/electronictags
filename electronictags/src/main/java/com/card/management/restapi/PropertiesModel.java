package com.card.management.restapi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@ConfigurationProperties
@Getter
@Setter
@NoArgsConstructor
public class PropertiesModel {
	private String apiUrl;
	private String apiQueryUrl;
	private String storeCode;
	private String templateIdPreparatory;
	private String templateIdAssemble;
	private String templateIdClear;
	private String sign;
	private String isBase64;
	private int maxWaitTime;
	private int requestTime;

}
