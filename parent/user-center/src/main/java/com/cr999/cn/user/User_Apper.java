package com.cr999.cn.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 文件描述：
 *
 * @version 1.0
 * @author wangqiang
 * @date 2021/4/5 0:02 
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.cr999.cn.user.biz.mapper"})
public class User_Apper {
    public static void main(String[] args) {
        SpringApplication.run(User_Apper.class,args);
    }

}
