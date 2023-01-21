package com.javaboy.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author peng
 * @Date 2021/8/16
 */
@Data
@Accessors(chain = true)
public class ProjectEvent {
    private String projectId;
    private String projectName;
    private String errMsg;
    private String creator;
    private Boolean success = false;
    private Boolean isSuccess =false;


    public boolean getIsSuccess() {
        return isSuccess = success;
    }
}
