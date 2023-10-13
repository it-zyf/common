package com.javaboy.common.strategy.two;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zyf
 * @date 2023/10/13 14:47
 */
@SpringBootTest
class BaseFactoryStrategyTest {
    @Test
    void getStrategyNoNull() {
        AbstractBaseFactoryStrategy strategy = BaseFactoryStrategy.getStrategyNoNull(2);
        strategy.pay();
    }

}