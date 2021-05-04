package com.userService.cn.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;


@Configuration
@PropertySources({@PropertySource("classpath:application-dev.properties"),@PropertySource("classpath:application-test.properties")})
public class TestPropertySources {
	
	@Value("${server.servlet.context-path}")
	private String contextPpath;
	
	public Environment env;
	public TestPropertySources(Environment env) {
		this.env=env;
	}
	
	public void showInfo() {
		System.out.println("spring.datasource.url:"+env.getProperty("spring.datasource.url"));
		System.out.println("server.servlet.context-path:"+contextPpath);
	}

}
