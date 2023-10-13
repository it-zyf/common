package com.javaboy.common.strategy.two;

import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2023/9/11 16:46
 */
@Service
public class ZfbBaseServiceImplTwo extends AbstractBaseFactoryStrategy {

    @Override
    protected MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.QQ;
    }

    @Override
    public void pay() {
        super.pay();
        System.out.println("支付宝支付逻辑");
    }
}
