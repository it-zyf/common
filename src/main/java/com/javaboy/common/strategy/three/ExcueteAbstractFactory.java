package com.javaboy.common.strategy.three;

import cn.hutool.core.lang.Assert;
import com.javaboy.common.constant.CodeConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyf
 * @date 2023/10/13 15:35
 */
public abstract class ExcueteAbstractFactory {
    public static final Map<Integer,CommonPayAbstract> PAY_MAP=new HashMap<>();

    public static void register(Integer markType, CommonPayAbstract strategy) {
        PAY_MAP.put(markType, strategy);
    }

    public static CommonPayAbstract getStrategyNoNull(Integer markType) {
        CommonPayAbstract strategy = PAY_MAP.get(markType);
        Assert.notNull(strategy, CodeConstant.PARAM_ERROR);
        return strategy;
    }
}
