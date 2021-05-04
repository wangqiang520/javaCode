package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${eurkea.client.service-url.defaultZone}")
	private String eurkeaServers;
	@Value("${server.port}")
	private String port;
	@RequestMapping("/config")
	public String getConfig() {
		String str="applicationName:"+applicationName+"\r eurkeaServers:"+eurkeaServers+"\r port"+port;
		System.out.println(str);
		return str;
	}
	

}
