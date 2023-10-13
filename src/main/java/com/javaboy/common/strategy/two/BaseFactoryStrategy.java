package com.javaboy.common.strategy.two;

import cn.hutool.core.lang.Assert;
import com.javaboy.common.constant.CodeConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyf
 * @date 2023/10/13 14:22
 */
public class BaseFactoryStrategy {

    private static final Map<Integer, AbstractBaseFactoryStrategy> STRATEGY_MAP = new HashMap<>();

    public static void register(Integer markType, AbstractBaseFactoryStrategy strategy) {
        STRATEGY_MAP.put(markType, strategy);
    }

    public static AbstractBaseFactoryStrategy getStrategyNoNull(Integer markType) {
        AbstractBaseFactoryStrategy strategy = STRATEGY_MAP.get(markType);
        Assert.notNull(strategy, CodeConstant.PARAM_ERROR);
        return strategy;
    }
}
