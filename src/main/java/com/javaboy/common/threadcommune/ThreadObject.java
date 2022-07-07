package com.javaboy.common.threadcommune;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 使用 Object 类的 wait()/notify()
 *
 * @author: zyf
 * @create: 2022-07-07 11:16
 **/
@RequiredArgsConstructor
@RequestMapping("/threadObject")
@RestController
public class ThreadObject {

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping("/wait")
    public void threadVolatile() {
        //定义一个锁对象
        Object lock = new Object();
        List<String> list = Lists.newArrayList();
        //线程B
        threadPoolTaskExecutor.submit(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() != 4) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                }
            }
        });
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程A
        threadPoolTaskExecutor.submit(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    list.add("abc");
                    System.out.println("线程A添加元素，此时list的size为：" + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 4){
                        lock.notifyAll();//唤醒B线程
                    }
                }
            }
        });

    }

    private void printList(List<String> list) {
        Optional.ofNullable(list).orElseGet(ArrayList::new).forEach(System.out::println);
    }


    public static void main(String[] args) {
        //定义一个锁对象
        Object lock = new Object();
        List<String> list = new ArrayList<>();
        // 线程A
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                for (int i = 1; i <= 10; i++) {
                    list.add("abc");
                    System.out.println("线程A添加元素，此时list的size为：" + list.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (list.size() == 5)
                        lock.notify();//唤醒B线程
                }
            }
        });
        //线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (list.size() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                }
            }
        });
        //需要先启动线程B
        threadB.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //再启动线程A
        threadA.start();
    }
}
