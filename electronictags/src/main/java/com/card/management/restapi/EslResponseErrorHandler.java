package com.card.management.restapi;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class EslResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		// 根据响应状态码判断是否有错误
        return !response.getStatusCode().is2xxSuccessful();
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		// 处理异常，例如记录日志或抛出自定义异常
        throw new IOException("基站请求异常!");
		
	}

}
