package com.javaboy.common.thread_test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * @author zyf
 * @date 2023/10/19 10:51
 */
@SpringBootTest
public class ThreadPoolTest {
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    private final ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
            10,
            20,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build()
    );


    @PostConstruct
    private void init() {
        threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setKeepAliveSeconds(0);
        threadPoolTaskExecutor.setThreadFactory(new ThreadFactoryBuilder().setNameFormat("thread-task-pool-%d").build());
        threadPoolTaskExecutor.initialize();
    }

    @Test
    void test(){
        CompletableFuture.runAsync(()->{
            System.out.println("123");
        },threadPoolTaskExecutor);


//        threadPoolExecutor.execute(()->{
//            System.out.println("threadPoolExecutor");
//        });
//
//        threadPoolTaskExecutor.execute(()->{
//            System.out.println("threadPoolTaskExecutor");
//        });
    }

}
