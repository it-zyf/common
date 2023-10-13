package com.javaboy.common.strategy.one;

import cn.hutool.core.util.ObjectUtil;
import com.javaboy.common.strategy.one.service.PayBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyf
 * @date 2023/9/11 16:54
 */
@Service
public class ExecuteFactory {
    //将所有的策略注入进来
    @Resource
    private List<PayBaseService> list;

    public void test(String payType)  {
        list.stream().filter(b-> ObjectUtil.equal(b.getPayType(),payType)).findAny().orElseThrow(()->new RuntimeException("未找到对应支付方式")).pay();
    }

}
