package com.javaboy.common.controller.redis.hotsort.controller;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.controller.redis.hotsort.service.HotSortService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-06-23 11:24
 **/
@RequestMapping("/hot")
@RequiredArgsConstructor
@RestController
public class HotSortController {

    private final HotSortService hotSortService;

    @ApiOperation("热点数据排序")
    @GetMapping("/sort")
    public ResponseMsg<List<Map<String, Object>>> hotSort(){
        return hotSortService.hotSort();
    }
}
