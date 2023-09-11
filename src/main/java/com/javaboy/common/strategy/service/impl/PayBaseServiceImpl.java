package com.javaboy.common.strategy.service.impl;

import com.javaboy.common.strategy.service.PayBaseService;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2023/9/11 16:48
 */
@Service
public class PayBaseServiceImpl implements PayBaseService {
    @Override
    public String getPayType() {
        return "qq";
    }

    @Override
    public void pay() {
        System.out.println("QQ支付逻辑");
    }
}
