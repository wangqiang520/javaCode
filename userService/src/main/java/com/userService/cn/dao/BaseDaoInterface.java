package com.userService.cn.dao;

import java.util.List;
import java.util.Map;

import com.userService.cn.po.LoginLogPo;

public interface BaseDaoInterface<T> {
	T findById(Integer id);
	List<T> queryList(Map<String,Object> map);
	Integer insert(T t);
	Integer delete(Integer id);
	Integer update(T t);
}
