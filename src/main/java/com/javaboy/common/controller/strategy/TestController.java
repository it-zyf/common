package com.javaboy.common.controller.strategy;

import com.javaboy.common.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 传统的if-else 或 switch 方法比较长
 *
 * @author: zyf
 * @create: 2022-01-28 11:35
 **/
@RequestMapping("/switch")
@RestController
public class TestController {
    @Autowired
    private StrategyService strategyService;

    @GetMapping("/test")
    public String test(String flag) {
        switch (flag) {
            case "1":
                System.out.println("查询红包");
                return "查询红包";
            case "2":
                System.out.println("查询qq会员");
                return "查询qq会员";
            case "3":
                System.out.println("查询外卖会员");
                return "查询外卖会员";
        }
        return "没有符合数据~~~~~~~~";
    }

    /**
     * map+函数试接口来代替if-else/switch 业务分配
     * @param flag
     * @return
     */
    @PostMapping("/test2")
    public String test2(@RequestBody FlagDto flag, HttpServletRequest request) {
        return strategyService.getResult(flag,request);
    }


}
