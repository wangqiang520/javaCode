package com.userService.cn.po;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor //全参构造函数
@NoArgsConstructor  //无参构造函数
@Data
//@Accessors(chain=true)
public class LoginLogPo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer userId;
	private String loginAddress;
	private Long loginTime;
	private Long logoutTime;
}
