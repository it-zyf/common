package com.javaboy.common.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;

/**
 * @author zyf
 */
@Component
@RequiredArgsConstructor
public class DoTransactionCompletion implements TransactionSynchronization{

    private final Runnable runnable;



    /**
     * 事务完成之后进行代码处理
     *
     * @param status
     */
    @Override
    public void afterCompletion(int status) {
        //当事务提交之后
        if (status == TransactionSynchronization.STATUS_COMMITTED) {
            this.runnable.run();
        }
    }

}
