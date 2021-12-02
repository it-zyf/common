package com.javaboy.common.controller;

import com.javaboy.common.entity.DtoEmail;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: zyf
 * @create: 2021-12-02 16:27
 **/
@RestController
@RequestMapping("/email")
public class EmailController {
    @RequestMapping("/test")
    public String email(@RequestBody @Valid DtoEmail dtoEmail){
        System.out.println("123");
        System.out.println(dtoEmail.getAaa());
        return "ok";
    }
}
