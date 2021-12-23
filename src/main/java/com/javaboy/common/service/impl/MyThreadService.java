package com.javaboy.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: zyf
 * @create: 2021-12-21 11:33
 **/
@Service
public class MyThreadService {
    @Autowired
    private HhService hhservice;

    @Autowired
    private ApplicationContext applicationContext;


    public String test() {
        MyThreadService bean = applicationContext.getBean(MyThreadService.class);
        bean.test2();
        return "hello";
    }

    @Async
    public void test2(){
        try {
            System.out.println("开始");
            Thread.sleep(10000);
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
