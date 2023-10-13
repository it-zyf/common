package com.javaboy.common.strategy.three;

import com.javaboy.common.strategy.two.MessageMarkTypeEnum;

import javax.annotation.PostConstruct;

/**
 * @author zyf
 * @date 2023/10/13 15:11
 */
public abstract class CommonPayAbstract implements CommonPayInterface{

    public abstract MessageMarkTypeEnum getTypeEnum();
    @PostConstruct
    public void  init(){
        ExcueteAbstractFactory.register(getTypeEnum().getType(),this);
    }


    @Override
    public void sumMoney() {
        System.out.println("公有的计价方式");
    }
}
