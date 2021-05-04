package com.userService.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import com.userService.cn.dao.LoginLogDao;
import com.userService.cn.po.LoginLogPo;
import com.userService.cn.service.LoginLogService;
import com.userService.cn.test.BeanMapUtils;

@Service
public class LoginLogServiceImpl implements LoginLogService {

	@Autowired
	LoginLogDao loginLogDao;
	
	@Override
	public LoginLogPo findById(Integer id) {
		return id!=null?loginLogDao.findById(id):new LoginLogPo();
	}

	@Override
	public List<LoginLogPo> queryList(Map<String, Object> map) {
		return loginLogDao.queryList(map);
	}
	public LoginLogPo mapToBean(Map<String, Object> map, LoginLogPo bean) {
	        BeanMap beanMap = BeanMap.create(bean);
	        beanMap.putAll(map);
	        return bean;
	}


	@Override
	public boolean delete(Integer id) {
		return id!=null?loginLogDao.delete(id)>0?true:false:false;
	}

	@Override
	public boolean update(LoginLogPo po) {
		return loginLogDao.update(po)>0?true:false;
	}

	@Override
	public boolean insert(LoginLogPo po) {
		return loginLogDao.insert(po)>0?true:false;
	}
}
