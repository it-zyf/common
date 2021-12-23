package com.javaboy.common.controller;


import com.javaboy.common.service.impl.MyThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zyf
 * @create: 2021-12-21 11:31
 **/
@RestController
@RequestMapping("/thread")
public class ThreadController {
    @Autowired
    private MyThreadService threadService;

    @GetMapping("/test")
    public String test() {
        return threadService.test();
    }
}
