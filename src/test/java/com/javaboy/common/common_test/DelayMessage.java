package com.javaboy.common.common_test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zyf
 * @date 2023/10/19 15:36
 */
@SpringBootTest
public class DelayMessage {

    @Test
   public void test(){
    Map<String, Long> levelDelay = new LinkedHashMap<>();
        levelDelay.put("__delay-seconds-1", 1000L);
        levelDelay.put("__delay-seconds-5", 1000L * 5);
        levelDelay.put("__delay-seconds-10", 1000L * 10);
        levelDelay.put("__delay-seconds-30", 1000L * 30);
        levelDelay.put("__delay-minutes-1", 1000L * 60);
        levelDelay.put("__delay-minutes-2", 1000L * 60 * 2);
        levelDelay.put("__delay-minutes-3", 1000L * 60 * 3);
        levelDelay.put("__delay-minutes-4", 1000L * 60 * 4);
        levelDelay.put("__delay-minutes-5", 1000L * 60 * 5);
        levelDelay.put("__delay-minutes-6", 1000L * 60 * 6);
        levelDelay.put("__delay-minutes-7", 1000L * 60 * 7);
        levelDelay.put("__delay-minutes-8", 1000L * 60 * 8);
        levelDelay.put("__delay-minutes-9", 1000L * 60 * 9);
        levelDelay.put("__delay-minutes-10", 1000L * 60 * 10);
        levelDelay.put("__delay-minutes-20", 1000L * 60 * 20);
        levelDelay.put("__delay-minutes-30", 1000L * 60 * 30);
        levelDelay.put("__delay-hours-1", 1000L * 60 * 60);
        levelDelay.put("__delay-hours-2", 1000L * 60 * 60 * 2);
        ArrayList<String> levels = new ArrayList<>(levelDelay.keySet());

        System.out.println(JSON.toJSONString(levels));
    }
}
