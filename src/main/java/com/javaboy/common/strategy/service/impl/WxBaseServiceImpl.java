package com.javaboy.common.strategy.service.impl;

import com.javaboy.common.strategy.service.PayBaseService;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2023/9/11 16:45
 */
@Service
public class WxBaseServiceImpl implements PayBaseService {
    @Override
    public String getPayType() {
        return "weChat";
    }

    @Override
    public void pay() {
        System.out.println("微信支付逻辑");
    }

}
