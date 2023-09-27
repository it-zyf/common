package com.javaboy.common.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author zyf
 * @date 2023/9/24 14:04
 */
@SpringBootTest
class NotNullInterfaceServiceTest {

    @Resource
    private NotNullInterfaceService notNullInterfaceService;

    @Test
    void notNullInterface() {

        notNullInterfaceService.notNullInterface( null,"123");
    }
}