package com.javaboy.common.blockqueue;

import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列消费
 * @author: zyf
 * @create: 2022-03-11 18:23
 **/
@Async
public class ConsumerQueue implements Runnable{

    private final BlockingQueue<String> conQueue;

    public ConsumerQueue(BlockingQueue conQueue) {
        this.conQueue = conQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                //take()方法获取并移除此队列的头部，说通俗点就是拿出来并且删掉，在元素变得可用之前一直等待 。queue的长度 == 0 的时候，一直阻塞，直到生产者又放入了新的数据。
                System.out.println("**************消费者消费的可乐编号为："+conQueue.take());
                //休眠一下方便看的更清楚
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //   Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
