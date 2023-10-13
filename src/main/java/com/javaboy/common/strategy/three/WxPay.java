package com.javaboy.common.strategy.three;

import com.javaboy.common.strategy.two.MessageMarkTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author zyf
 * @date 2023/10/13 15:12
 */
@Component
public class WxPay extends CommonPayAbstract{
    @Override
    public void pay() {
        System.out.println("微信支付");
    }

    @Override
    public MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.WECHAT;
    }
}
