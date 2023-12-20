package com.javaboy.common.request;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.CompletableFuture;

/**
 * @author zyf
 * @date 2023/10/27 14:52
 */
@RequestMapping("/request")
@RestController
public class RequestController {

    @GetMapping("/test")
    public String test() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        String hh = requestAttributes.getRequest().getHeader("hh");
        System.out.println(hh);
        return "hh";
    }


    @GetMapping("/test2")
    public String test2() {
        CompletableFuture.runAsync(() -> {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            String hh = requestAttributes.getRequest().getHeader("hh");
            System.out.println(hh);
        });

        return "ok";
    }
}
