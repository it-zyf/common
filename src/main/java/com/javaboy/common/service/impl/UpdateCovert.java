package com.javaboy.common.service.impl;

import com.javaboy.common.annotations.Covert;
import com.javaboy.common.entity.RecordOperationDto;
import com.javaboy.common.entity.UpdateOrder;
import org.springframework.stereotype.Service;

/**
 * @author zyf
 * @date 2022/12/6 17:03
 */
@Service
public class UpdateCovert  implements Covert<UpdateOrder> {
    @Override
    public RecordOperationDto cover(UpdateOrder updateOrder) {
        RecordOperationDto recordOperationDto = new RecordOperationDto();
        recordOperationDto.setId(updateOrder.getId());
        return recordOperationDto;
    }
}
