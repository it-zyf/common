package com.javaboy.common.countdownlatch.service;

import com.javaboy.common.countdownlatch.entity.DownLatchCheck;

import java.util.List;

/**
 * @author zyf
 * @date 2023/1/21 11:09
 */
public interface CountDownLatchService {
    /**
     * 做大数据量的校验
     * @return
     */
    List<DownLatchCheck> checkLongNum();


}
