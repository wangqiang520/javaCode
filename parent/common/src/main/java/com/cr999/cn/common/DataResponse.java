package com.cr999.cn.common;

import lombok.Data;

/**
 * Created by @author songjhh on 2018/8/31
 */
@Data
public class DataResponse<D> extends BaseResponse {

	private D data;

	public DataResponse() {
	}

	public DataResponse(int code) {
		super(code);
	}

	public DataResponse(int code, D data) {
		super(code);
		this.setData(data);
	}

	public DataResponse(int code, String message) {
		super(code);
		this.setMessage(message);
	}

	public DataResponse(String message, D data) {
		super(message);
		this.setData(data);
	}

	public DataResponse(int code, String message, D data) {
		super(code, message);
		this.setData(data);
	}


}
