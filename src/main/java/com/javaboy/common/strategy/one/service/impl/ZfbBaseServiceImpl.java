package com.javaboy.common.strategy.one.service.impl;

import com.javaboy.common.strategy.one.service.PayBaseService;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2023/9/11 16:46
 */
@Service
public class ZfbBaseServiceImpl implements PayBaseService {
    @Override
    public String getPayType() {
        return "zfb";
    }

    @Override
    public void pay() {
        System.out.println("支付宝支付逻辑");
    }
}
