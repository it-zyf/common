package com.javaboy.common.service.impl;

import com.javaboy.common.annotations.Covert;
import com.javaboy.common.entity.RecordOperationDto;
import com.javaboy.common.entity.SaveOrder;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2022/12/6 17:05
 */
@Service
public class SaveCover implements Covert<SaveOrder> {
    @Override
    public RecordOperationDto cover(SaveOrder saveOrder) {
        RecordOperationDto recordOperationDto = new RecordOperationDto();
        recordOperationDto.setId(saveOrder.getOrderId());
        return recordOperationDto;
    }
}
