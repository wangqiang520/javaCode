package com.userService.cn.util;

public enum ConstantEnum {
	EXPIRE_DATE("600000","过期日期"),
	TOKEN_SECRET("ZCfasfhuaUUHufguGuwu2020BQWE","token密钥"),
	USER_TOKEN_PREFIX("user_token:","用户Token前缀");
	
	private String value;
    private String msg;
	private ConstantEnum(String value, String msg) {
		this.value = value;
		this.msg = msg;
	}
	
	public String getValue() {
		return value;
	}
	public String getMsg() {
		return msg;
	}
}
