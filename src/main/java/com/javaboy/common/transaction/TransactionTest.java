package com.javaboy.common.transaction;

import com.javaboy.common.service.MyTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事务的一个测试类
 * @author: zyf
 * @create: 2022-03-18 09:58
 **/
@RequestMapping("/transaction")
@RestController
@RequiredArgsConstructor
public class TransactionTest {

    private final MyTransactionService myTransactionService;

    @GetMapping("/test")
    public String transactionTest(){
        return myTransactionService.transactionTest();
    }

    @GetMapping("/test2")
    public String test2(){
        return myTransactionService.transactionTest2();
    }


}
