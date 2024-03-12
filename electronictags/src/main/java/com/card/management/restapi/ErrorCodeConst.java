package com.card.management.restapi;

public enum ErrorCodeConst {
	MSG1001("1001","批量号不存在!"),
	MSG1002("1002","批量号已经使用!"),
	MSG1003("1003","单项目有错误"),
	MSG9001("9001","系统异常!"),
	MSG9002("9002","基站连接超时!"),
	MSG6001("6001","处理正常终了!");
	
	private final String code;
	private final String message;
	ErrorCodeConst(String code,String message) {
		this.code=code;
		this.message=message;
	}
	
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
