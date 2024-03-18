package com.card.management.restapi;

public enum ErrorCodeConst {
	MSG1001("1001","批量号不存在!"),
	MSG1002("1002","批量号已经使用!"),
	MSG1003("1003","项目输入有错误，请检查是否有必须项目没有输入等问题......"),
	MSG1004("1004","请先完成耐压!"),
	MSG1005("1005","请先完成接地!"),
	MSG1006("1006","请先完成组装!"),
	MSG9001("9001","服务器系统异常!"),
	MSG9002("9002","基站数据写入错误!"),
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
