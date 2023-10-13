package com.javaboy.common.strategy.two;

import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2023/9/11 16:45
 */
@Service
public class WxBaseServiceImplTwo extends AbstractBaseFactoryStrategy {


    @Override
    protected MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.WECHAT;
    }


    @Override
    public void pay() {
        super.pay();
        System.out.println("微信支付");
    }

}
