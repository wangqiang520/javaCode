package com.userService.cn.util;

public enum ResultEnum {
	////通用的错误码
	SUCCESS(200,"成功"),
	SERVER_ERROR(500100, "服务端异常"),
	PARAMETER_ERROR(500101, "参数校验异常：%s"),
	REQUEST_ILLEGAL(500102, "请求非法"),
	ACCESS_LIMIT_REACHED(500103, "访问太频繁！"),
	
	//用户状态码5002xx
	USER_NOT_LOGIN(500200, "用户未登录"),
	TOKEN_EXPIRE(500201, "token无效"),
	USERLOGIN_AND_PASSWORD_ERROR(500202,"用户名和密码错误"),
	USERLOGIN_AND_PASSWORD_IS_EMPTY(500203,"用户名和密码不能为空"),
	USERLOGIN_IS_EXISTS(500204,"用户已存在"),
	
	//token状态码5003xx
	CHECK_TOKEN_ERROR(500300,"校验Token异常"),
	GENERATION_TOKEN_ERROR(500301,"生成Token异常"),
	
	//数据库操作状态码5004xx
	ADD_DATA_ERROR(500400,"添加数据异常"),
	
	
	//redis错误码5005xx
	REDIS_ADD_ERROR(500500,"Redis添加数据异常"),
	
	
	
	
	
	
	
	test(1,"test");
	/*UNKNOWN_ERROR("-1","未知错误"),
	SUCCESS("0000","成功"),
	USER_NOT_EXIST("1","用户不存在"),
	USER_IS_EXISTS("2","用户已存在"),
	DATA_IS_NULL("3","数据为空"),
	ADD_FAIL("4","添加失败"),
	PARAMETER_CHECK_FAIL("5","参数校验失败"),
	PARAMETER_IS_EMPTY("6","参数不能为空"),
	//用户
	USERLOGIN_AND_PASSWORD_IS_EMPTY("7","用户名和密码不能为空"),
	USERLOGIN_AND_PASSWORD_IS_ERR("8","用户名和密码错误"),
	CHECK_TOKEN_FAIL("9","校验Token失败"),
	GENERATION_TOKEN_FAIL("10","生成Token失败"),
	REDIS_ADD_FAIL("11","Redis添加数据失败");*/
	
	private Integer code;
    private String msg;
    
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}

}
