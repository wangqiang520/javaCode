package com.cr999.cn.common;

/**
 * Created by @author songjhh on 2018/8/31
 */
public class BaseResponse {

    private int code = 200;
    private String message;

    public BaseResponse() {}

    public BaseResponse(int code) {
        this.setCode(code);
    }

    public BaseResponse(String message) {
        this.setCode(0);
        this.setMessage(message);
    }

    public BaseResponse(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
