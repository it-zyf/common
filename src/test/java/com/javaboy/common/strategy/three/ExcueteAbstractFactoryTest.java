package com.javaboy.common.strategy.three;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyf
 * @date 2023/10/13 15:46
 */
@SpringBootTest
class ExcueteAbstractFactoryTest {

    @Resource
    private List<CommonPayAbstract> list;

    @Test
    void getStrategyNoNull() {
        CommonPayAbstract strategyNoNull = ExcueteAbstractFactory.getStrategyNoNull(2);
        strategyNoNull.pay();
    }

    @Test
    void getStrategyNoNull2() {
        CommonPayAbstract commonPayAbstract = list.stream().filter(l -> l.getTypeEnum().getType() == 2).findFirst().get();
        commonPayAbstract.pay();
    }
}