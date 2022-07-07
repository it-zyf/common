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
 * volatile 关键字实现多线程对共享变量的感知
 *
 * @author: zyf
 * @create: 2022-07-07 10:27
 **/
@RequiredArgsConstructor
@RequestMapping("/thread")
@RestController
public class ThreadVolatile {
    /**
     * 定义共享变量来实现通信，它需要volatile修饰，否则线程不能及时感知
     */
    static volatile boolean notice = false;

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping("/volatile")
    public void threadVolatile(){
        List<String> list = Lists.newArrayList();
        //线程B
        threadPoolTaskExecutor.submit(()->{
            while (true) {
                if (notice) {
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    printList(list);
                    break;
                }
            }
        });

        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        //线程A
        threadPoolTaskExecutor.submit(()->{
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A添加元素，此时list的size为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 4) notice = true;
            }
        });

    }


    private void printList(List<String> list){
        Optional.ofNullable(list).orElseGet(ArrayList::new).forEach(System.out::println);
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        //线程A
        Thread threadA = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                list.add("abc");
                System.out.println("线程A添加元素，此时list的size为：" + list.size());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (list.size() == 4) notice = true;
            }
        });
        //线程B
        Thread threadB = new Thread(() -> {
            while (true) {
                if (notice) {
                    System.out.println("线程B收到通知，开始执行自己的业务...");
                    break;
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
