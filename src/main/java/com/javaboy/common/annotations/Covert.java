package com.javaboy.common.annotations;

import com.javaboy.common.entity.RecordOperationDto;

/**
 * @author zyf
 * @date 2022/12/6 16:48
 */
public interface Covert <PARAM>{
    /**
     * 转换入参
     * @param param
     * @return
     */
    RecordOperationDto cover(PARAM param);
}
