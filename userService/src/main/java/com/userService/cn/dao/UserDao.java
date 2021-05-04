package com.userService.cn.dao;

import com.userService.cn.po.UserPo;

public interface UserDao extends BaseDaoInterface<UserPo>{
	UserPo findByUserLoginAndPassWord(UserPo userPo);
}
