package com.javaboy.common.topo;

import lombok.Data;

/**
 * @author zyf
 * @date 2023/4/27 15:16
 */
@Data
public class RangeEntity {
    private String rangeId;

    private String rangeProjectId;

    public RangeEntity(String rangeId, String rangeProjectId) {
        this.rangeId = rangeId;
        this.rangeProjectId = rangeProjectId;
    }

}
