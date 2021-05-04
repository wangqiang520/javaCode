package com.userService.cn.service;

import java.util.List;
import java.util.Map;

import com.userService.cn.po.UserPo;
import com.userService.cn.vo.UserVo;

public interface TestUserService {
	UserPo getUserById(Integer id);
	List<UserPo> queryUserList(Map<String,Object> map);
	boolean updateUser(Map<String,Object> map);
	boolean insertUser(UserVo vo);
	boolean deleteUser(Integer id);
	/**
	 * 查询证件号和手机号是否存在
	 * @param map
	 * @return
	 */
	List<UserPo> queryUserIdCartOrTelephoneList(Map<String,Object> map);
}
