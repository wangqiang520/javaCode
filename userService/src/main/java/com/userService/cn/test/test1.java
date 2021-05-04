package com.userService.cn.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.beans.BeanMap;

import com.userService.cn.po.LoginLogPo;

import org.apache.commons.beanutils.BeanUtils;
public class test1 {
	public static LoginLogPo mapToBean(Map<String, Object> map, LoginLogPo bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
	public static void main(String[] args) {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("id", 1);
		map.put("userId", 2);
		map.put("loginAddress", "127.0.0.1");
		map.put("loginTime", 3l);
		map.put("logoutTime", 4l);
		try {
			LoginLogPo a=BeanMapUtils.mapToBean(map, LoginLogPo.class);
			LoginLogPo t=new LoginLogPo();
			BeanUtils.populate(t, map);
			System.out.println(t.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
