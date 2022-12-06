package com.javaboy.common.service.impl;

import com.javaboy.common.annotations.RecordOperation;
import com.javaboy.common.entity.SaveOrder;
import com.javaboy.common.entity.UpdateOrder;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2022/12/6 16:57
 */
@Service
public class OrderService {

    @RecordOperation(desc = "保存操作",covert = SaveCover.class)
    public boolean saveOrder(SaveOrder saveOrder){
        System.out.println("orderId:{}"+saveOrder.getOrderId());
        return true;
    }

    @RecordOperation(desc = "更新操作",covert =UpdateCovert.class)
    public boolean updateOrder(UpdateOrder updateOrder){
        System.out.println("orderId:{}"+updateOrder.getId());
        return true;
    }
}
