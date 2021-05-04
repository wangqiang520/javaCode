package com.userService.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
//扫描Mapper类的包的路径
@MapperScan("com.userService.cn.dao")
@EnableDubbo
@EnableScheduling
//开启Aspect代理
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class UserServiceApp {
	
	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(UserServiceApp.class);
		app.run(args);
	}
}
