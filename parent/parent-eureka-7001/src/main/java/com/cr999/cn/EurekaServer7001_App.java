package com.cr999.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/3/17 21:45 
 */
@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器启动类，接受其它微服务注册进来
public class EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class, args);
    }
}
