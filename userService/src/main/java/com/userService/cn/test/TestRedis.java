package com.userService.cn.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
public class TestRedis {
	private RedisTemplate<String, String> redisTemplate;
	
	public void get() {
		String a=redisTemplate.opsForValue().get("UserKey:access444");
		System.out.println(a);
	}

}
