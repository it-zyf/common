package com.javaboy.common.service;

import com.javaboy.common.controller.strategy.FlagDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author: zyf
 * @create: 2022-01-28 14:05
 **/
@Service
public class StrategyService {

    @Autowired
    StrategyServiceImpl strategyServiceImpl;

    private final Map<String, Function<FlagDto, String>> grantTypeMap=new HashMap<>();

    @PostConstruct
    public void dispatcherInit(){
        grantTypeMap.put("1",flagDto->strategyServiceImpl.flagOne(flagDto));
        grantTypeMap.put("2",flagDto->strategyServiceImpl.flagTwo(flagDto));
        grantTypeMap.put("3",flagDto->strategyServiceImpl.flagThree(flagDto));
    }

    public String getResult(FlagDto flag, HttpServletRequest request){
        flag.setToken(request.getHeader("token"));
        Function<FlagDto, String> function = grantTypeMap.get(flag.getFlag());
        if(function !=null){
            return function.apply(flag);
        }
        return "没有符合数据~~~~~~~~";
    }
}
