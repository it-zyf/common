package com.javaboy.common.strategy.three;

import com.javaboy.common.strategy.two.MessageMarkTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author zyf
 * @date 2023/10/13 15:13
 */
@Component
public class QqPay extends CommonPayAbstract{

    @Override
    public MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.QQ;
    }

    @Override
    public void pay() {
        System.out.println("QQ支付");
    }
}
