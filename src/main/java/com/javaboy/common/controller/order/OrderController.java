package com.javaboy.common.controller.order;

import com.javaboy.common.entity.SaveOrder;
import com.javaboy.common.entity.UpdateOrder;
import com.javaboy.common.service.impl.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author zyf
 * @date 2022/12/6 17:08
 * AOP 区分接口,保存打印日志.
 */
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/saveOrder")
    public void saveOrder() {
        SaveOrder saveOrder = new SaveOrder();
        saveOrder.setOrderId("123");
        orderService.saveOrder(saveOrder);
    }

    @GetMapping("/updateOrder")
    public void updateOrder() {
        UpdateOrder updateOrder = new UpdateOrder();
        updateOrder.setId("321");
        orderService.updateOrder(updateOrder);
    }

}
