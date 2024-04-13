package com.card.management.restapi;

public enum ErrorCodeConst {
	MSG1001("1001","批量号不存在!"),
	MSG1002("1002","批量号已经使用!"),
	MSG1003("1003","项目输入有错误，请检查是否有必须项目没有输入等问题......"),
	MSG1004("1004","请先完成耐压!"),
	MSG1005("1005","请先完成接地!"),
	MSG1006("1006","请先完成组装!"),
	MSG1007("1007","水墨屏已被使用，请解绑后在使用!"),
	MSG1008("1008","水墨屏和绑定的车数不能都为空!"),
	MSG1009("1009","本批次已经处理完成，不能在继续登录!"),
	MSG1010("1010","小票信息已经被使用，请确认!"),
	MSG9001("9001","服务器系统异常!"),
	MSG9002("9002","基站数据写入错误!"),
	MSG9003("9003","基站连接超时！"),
	MSG9004("9004","以下电子卡片信息清除失败！请确认！"),
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
