package com.cr999.cn.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/1 23:13 
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"com.cr999.cn.*"})
public class Test_App {
    public static void main(String[] args) {
        SpringApplication.run(Test_App.class,args);
    }

}
