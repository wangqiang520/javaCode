package com.cr999.cn.com.biz.aop;

import com.cr999.cn.com.biz.componet.TransactionalUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 文件描述：
 * 自定义事务注解AOP
 * @version 1.0
 * @author wangqiang
 * @date 2021/3/28 20:26 
 */
//@Aspect
//@Component
public class ExtTransactionalAop {
/*
    @Autowired
    TransactionalUtils transactionalUtils;

    *//**
     * 如果有ExtTransactional这个注解，进入环绕通知，实现手动提交事务，如果遇到异常，手动回滚事务
     * @param joinPoint
     * @return
     *//*
    @Around(value = "@annotation(com.cr999.cn.com.biz.annotation.ExtTransactional)")
    public Object around(ProceedingJoinPoint joinPoint) {
        TransactionStatus transactionStatus =null;
        try {
            transactionStatus = transactionalUtils.beginTransactionl();
            //执行目标方法
            Object proceed = joinPoint.proceed();
            //手动提交事务
            transactionalUtils.commitTransactional(transactionStatus);
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            if(transactionStatus!=null){
                //手动回滚事务
                transactionalUtils.rollbackTransactional(transactionStatus);
            }
        }
        return null;

    }*/

}
