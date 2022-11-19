package com.javaboy.common.util;

import org.springframework.transaction.support.TransactionSynchronization;

/**
 * @author zyf
 */
public class DoTransactionCompletion implements TransactionSynchronization {

    private Runnable runnable;

    public DoTransactionCompletion(Runnable runnable) {
        this.runnable = runnable;
    }

    /**
     * 事务完成之后进行代码处理
     *
     * @param status
     */
    @Override
    public void afterCompletion(int status) {
        //当事务提交之后
        if (status == TransactionSynchronization.STATUS_COMMITTED) {
            runnable.run();
        }
    }

}
