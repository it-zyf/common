package com.javaboy.common.util;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author zyf
 */
public class TransactionUtils implements TransactionSynchronization{


    public static void doAfterTransaction(DoTransactionCompletion doTransactionCompletion) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(doTransactionCompletion);
        }
    }



}


