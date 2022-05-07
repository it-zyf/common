package com.javaboy.common.controller.hh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yayu
 * @title: GetHh
 * @description:   springboot 通过value获取到一些路径等配置信息
 * @date 2020/8/14 12:08
 */
@RestController
@RequestMapping("/get")
public class GetHh {
    @Value("${test.hh}")
    private String hh;

    @RequestMapping("/value")
    public String getHh() {
        return hh;
    }

}
