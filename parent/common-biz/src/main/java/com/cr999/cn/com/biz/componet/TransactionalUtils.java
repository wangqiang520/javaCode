package com.cr999.cn.com.biz.componet;/**
 * 文件描述：
 *
 * @author wangqiang
 * @date
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 文件描述：
 * 手动开启事务
 * @version 1.0
 * @author wangqiang
 * @date 2021/3/28 19:22 
 */
//@Component
//@Transactional
public class TransactionalUtils {

   /* @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    *//**
     * 开启事务
     * 事务隔离级别属于mysql的，传播行为属于spring
     * @return
     *//*
    public TransactionStatus beginTransactionl(){
        DefaultTransactionDefinition defaultTransactionDefinition=new DefaultTransactionDefinition();
        //设置传播行为
        defaultTransactionDefinition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus transactionStatus=dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);
        return transactionStatus;
    }

    *//**
     * 提交事务
     * @param transactionStatus
     *//*
    public void commitTransactional(TransactionStatus transactionStatus){
        dataSourceTransactionManager.commit(transactionStatus);
    }

    *//**
     * 回滚事务
     * @param transactionStatus
     *//*
    public void rollbackTransactional(TransactionStatus transactionStatus){
        dataSourceTransactionManager.rollback(transactionStatus);
    }*/

}
