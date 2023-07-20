package com.javaboy.common.thread_test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author zyf
 * @date 2023/6/25 15:21
 */
@SpringBootTest
public class Test {
    private ExecutorService cleanProjectVmPool = new ThreadPoolExecutor(
            10,
            20,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadFactoryBuilder().setNameFormat("clean-project-vm-pool-%d").build()
    );

    @org.junit.Test
    public void test() {
        List<String> users = Lists.newArrayList("zhangsan","lisi","wangwu","zhaoliu");
        CountDownLatch countDownLatch = new CountDownLatch(users.size());
        for (String user : users) {
            cleanProjectVmPool.execute(() -> {
                //去做操作
                //循环等待返回结果
                while (true) {
                    if (user.equals("wangwu")) {
                        throw new RuntimeException("操作超时");
                    }
                    System.out.println(user);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                countDownLatch.countDown();
            });
        }
        System.out.println(123);

    }

    @org.junit.Test
    public void test2(){
        String a ="87";
        System.out.println(Integer.valueOf(a));
    }



}
