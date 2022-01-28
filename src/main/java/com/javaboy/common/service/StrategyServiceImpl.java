package com.javaboy.common.service;

import com.javaboy.common.controller.strategy.FlagDto;
import org.springframework.stereotype.Service;

/**
 *
 * 这个service 主要用来实现每个分支的业务处理.
 * @author: zyf
 * @create: 2022-01-28 14:10
 **/
@Service
public class StrategyServiceImpl {

    public String flagOne(FlagDto flag){
        System.out.println("查询红包"+flag.getFlag()+flag.getToken());
        return "查询红包";
    }

    public String flagTwo(FlagDto flag){
        System.out.println("查询qq会员"+flag+flag.getToken());
        return "查询qq会员";
    }

    public String flagThree(FlagDto flag){
        System.out.println("查询外卖会员"+flag+flag.getToken());
        return "查询外卖会员";
    }
}
