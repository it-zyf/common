package com.javaboy.common.controller.page;

import com.javaboy.common.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yayu
 * @title: MybatisTest
 * @description:
 * @date 2022/1/16 14:40
 */
@RestController
@RequestMapping("/page")
public class MybatisController {
    @Autowired
    MybatisService mybatisservice;

    @RequestMapping("/mybatis")
    public Map<String, Object> getAll(@RequestBody Teacher teacher){
        return mybatisservice.getAll(teacher);
    }

}
