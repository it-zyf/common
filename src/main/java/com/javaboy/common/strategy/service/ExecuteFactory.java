package com.javaboy.common.strategy.service;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyf
 * @date 2023/9/11 16:54
 */
@Service
public class ExecuteFactory {
    @Resource
    private List<PayBaseService> list;

    public void test(String payType){
        list.stream().filter(b-> ObjectUtil.equal(b.getPayType(),payType)).findAny().orElseThrow(()->new RuntimeException("未找到对应支付方式")).pay();
    }

}
