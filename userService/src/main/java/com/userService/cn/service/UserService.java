package com.userService.cn.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.userService.cn.po.UserPo;
import com.userService.cn.util.Result;

public interface UserService extends BaseServiceInterface<UserPo> {
	
	Result login(String userLogin,String passWord,Integer isCookie, HttpServletRequest request,HttpServletResponse response);
	UserPo currentLoginUser(String token);
}
