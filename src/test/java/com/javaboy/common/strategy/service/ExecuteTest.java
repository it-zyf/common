package com.javaboy.common.strategy.service;

import com.javaboy.common.strategy.ExecuteFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zyf
 * @date 2023/9/11 16:58
 */
@SpringBootTest
class ExecuteTest {
    @Resource
    private ExecuteFactory executeFactory;


    @Test
    void test1() {
        executeFactory.test("qq");
    }
}