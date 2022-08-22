package com.javaboy.common.service;

/**
 * @author: zyf
 * @create: 2022-03-18 10:01
 **/
public interface MyTransactionService {
    /**
     * 事务测试类
     * @return
     */
    String transactionTest();

    /**
     * 事务失效测试
     * @return
     */
    String transactionTest2();

}
