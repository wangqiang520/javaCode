package com.userService.cn.service;

import java.util.List;
import java.util.Map;

public interface BaseServiceInterface<T> {

	T findById(Integer id) throws Exception;
	List<T> queryList(Map<String,Object> map) throws Exception;
	boolean insert(T t) throws Exception;
	boolean delete(Integer id) throws Exception;
	boolean update(T t) throws Exception;
}
