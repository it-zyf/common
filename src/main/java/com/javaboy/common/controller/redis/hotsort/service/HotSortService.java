package com.javaboy.common.controller.redis.hotsort.service;

import com.javaboy.common.api.ResponseMsg;

import java.util.List;
import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-06-23 11:28
 **/
public interface HotSortService {
    /**
     * 热点数据排序
     * @return
     */
    ResponseMsg<List<Map<String, Object>>> hotSort();

}
