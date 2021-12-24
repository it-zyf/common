package com.javaboy.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    public String test() {
        MyThreadService bean = applicationContext.getBean(MyThreadService.class);
        bean.test2();
        return "hello";
    }

    @Async
    public void test2() {
        try {
            System.out.println("开始");
            Thread.sleep(10000);
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String allTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        List<Integer> list1 = new ArrayList<>();
        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(integer -> {
            taskExecutor.submit(() -> {
//                System.out.println("线程-" + Thread.currentThread().getId() + "在执行写入");
//                System.out.println(integer);
                list1.add(integer);
            });
        });
        List<Integer> collect = list1.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        collect.forEach(integer -> System.out.println(integer));
        return "ok!";

    }
}
