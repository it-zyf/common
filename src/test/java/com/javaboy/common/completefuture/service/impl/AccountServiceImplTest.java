package com.javaboy.common.completefuture.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.javaboy.common.completefuture.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyf
 * @date 2023/9/27 17:30
 */
@SpringBootTest
class AccountServiceImplTest {
    @Resource
    private AccountService accountService;

    @Test
    void queryAllList() {
        List<String> list = accountService.queryAllList();
        System.out.println(JSONObject.toJSONString(list));
    }
}