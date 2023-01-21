package com.javaboy.common.countdownlatch.controller;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.javaboy.common.countdownlatch.entity.DownLatchCheck;
import com.javaboy.common.countdownlatch.service.CountDownLatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zyf
 * @date 2023/1/21 11:04
 */
@RestController
@RequestMapping("/down")
@RequiredArgsConstructor
public class CountDownLatch {

    private final CountDownLatchService countDownLatchService;

    @GetMapping("/latch")
    public String checkLongNum() {
        List<DownLatchCheck> checks = countDownLatchService.checkLongNum();
        if (CollUtil.isEmpty(checks)) {
            return "校验通过";
        }
        return JSON.toJSONString(checks);
    }
}
