package com.javaboy.common.controller.redis.hotsort.start;

import com.javaboy.common.controller.redis.hotsort.service.impl.HotSortServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: zyf
 * @create: 2022-06-23 14:13
 **/
@Component
@Order(value = 1)
@Slf4j
public class HotDataStart implements ApplicationRunner {
    @Autowired
    private HotSortServiceImpl hotSortService;
    @Override
    public void run(ApplicationArguments args) {
        hotSortService.initHotData();
    }
}
