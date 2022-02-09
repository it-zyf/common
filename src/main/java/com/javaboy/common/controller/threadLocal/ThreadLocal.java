package com.javaboy.common.controller.threadLocal;

import com.javaboy.common.util.ThreadLocalUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zyf
 * @create: 2022-02-09 18:20
 **/
@RequestMapping("/threadLocal")
@RestController
public class ThreadLocal {
    @RequestMapping("/add")
    public String test() {
        ThreadLocalUtil.set("userId","1");
        Object userId = ThreadLocalUtil.get("userId");
        ThreadLocalUtil.remove();
        return (String)userId;
    }

    @RequestMapping("/get")
    public String test2() {
        Object userId = ThreadLocalUtil.get("userId");
        return (String)userId;
    }

    @RequestMapping("/remove")
    public void test3(){
        ThreadLocalUtil.remove();
    }
}
