package com.javaboy.common.blockqueue;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.BlockingQueue;

/**
 * 生产阻塞的方法(nacos阻塞队列+异步多线程消费)
 * @author: zyf
 * @create: 2022-03-11 18:19
 **/
@Async
public class ProductQueue implements Runnable {

    private final BlockingQueue proQueue;

    public ProductQueue(BlockingQueue proQueue) {
        this.proQueue = proQueue;
    }



    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            try {
                //放入10瓶可乐 编号为0到9 也就是1-10 i初始单位为0
                //put()方法将指定元素插入此队列中，将等待可用的空间.通俗点说就是>maxSize 时候，阻塞，直到能够有空间插入元素
                System.out.println("生产的可乐编号为："+i);
                proQueue.put(i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
