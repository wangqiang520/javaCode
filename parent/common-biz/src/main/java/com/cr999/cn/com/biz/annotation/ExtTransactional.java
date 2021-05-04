package com.cr999.cn.com.biz.annotation;

import java.lang.annotation.*;

/**
 * 文件描述：
 * 自定义事务注解
 * @author wangqiang
 * @date
 */

//标记这个注解是否包含在用户文档中
@Documented
//用于设定注解的生命周期
@Retention(RetentionPolicy.RUNTIME)
//用于设定注解使用范围（此注解只允许使用在类或方法上）
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ExtTransactional {
}
