package com.cr999.cn.com.biz.exception;

import lombok.Data;

/**
 * 文件描述：
 * 自定义异常
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/1 22:18 
 */
@Data
public class CustomException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public static final int EXCEPTION_ERROR_CODE = 555;

    private String msg;
    private int code = 555;

    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CustomException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CustomException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CustomException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
