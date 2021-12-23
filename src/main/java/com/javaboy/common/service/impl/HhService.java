package com.javaboy.common.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: zyf
 * @create: 2021-12-21 11:37
 **/
@Async
@Service
public class HhService {
    public void test(){
        try {
            System.out.println("开始");
            Thread.sleep(10000);
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
