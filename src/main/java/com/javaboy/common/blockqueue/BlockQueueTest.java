package com.javaboy.common.blockqueue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 程序主方法
 * @author: zyf
 * @create: 2022-03-11 18:25
 **/
@RestController
@RequestMapping("/block")
public class BlockQueueTest {

    @GetMapping("/test")
    public  String test(){
        //自定义大小为5一个盒子 这里需要注意0到5是六次
        BlockingQueue publicQueue = new ArrayBlockingQueue(5);
        //实例化生产者
        ProductQueue pro = new ProductQueue(publicQueue);
        //实例化消费者
        ConsumerQueue con = new ConsumerQueue(publicQueue);
        //实例化生产者线程
        Thread t1 = new Thread(pro);
        //实例化消费者线程
        Thread t2 = new Thread(con);
        //启动两个线程
        t1.start();
        t2.start();
        return "ok";
    }

}
