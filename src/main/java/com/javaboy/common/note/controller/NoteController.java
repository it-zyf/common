package com.javaboy.common.note.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zyf
 * @date : 2022/8/17 10:59
 */
@RequestMapping("/note")
@RestController
public class NoteController {
    private static final String TOKEN="token";

    @GetMapping("/token")
    public void test(@RequestHeader(TOKEN) String token){
        System.out.println(token);
    }
}
