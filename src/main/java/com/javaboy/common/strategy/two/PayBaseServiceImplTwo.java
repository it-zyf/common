package com.javaboy.common.strategy.two;

import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2023/9/11 16:48
 */
@Service
public class PayBaseServiceImplTwo extends AbstractBaseFactoryStrategy{

    @Override
    protected MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.COMMON;
    }

    @Override
    void pay() {
        super.pay();
        System.out.println("通用支付");
    }
}
