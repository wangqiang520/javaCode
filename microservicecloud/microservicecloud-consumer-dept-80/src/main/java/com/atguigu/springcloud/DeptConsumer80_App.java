package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.atguigu.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们自定义Ribbon配置类，
//从而使配置生效（MySelfRule类不能配置在@ComponentScan所扫描的当前包下以及子包下，
//否则我们自定义的这个配置类就会被 所有的Ribbon客户端共享，也就是说我们达不到特殊化定制目的了）
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class) 
public class DeptConsumer80_App {
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
