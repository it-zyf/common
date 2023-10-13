package com.javaboy.common.strategy.two;

import javax.annotation.PostConstruct;

/**
 * @author zyf
 * @date 2023/10/13 14:23
 */
public abstract class AbstractBaseFactoryStrategy {

    protected abstract MessageMarkTypeEnum getTypeEnum();

    //把当前的策略注入到策略工厂中
    @PostConstruct
    public void init(){
        BaseFactoryStrategy.register(getTypeEnum().getType(),this);
    }


    void pay() {
        //这里结合理解
        //1.公共有的地方来做标记
        //2.喜欢,就做取消喜欢
        //3.不喜欢,就做取消喜欢操作
        //也可以理解为,这里是做价钱的计算,等计算完成后,在通过参数来决定使用哪种支付方式
        System.out.println("公有计算方式");
    }
}
