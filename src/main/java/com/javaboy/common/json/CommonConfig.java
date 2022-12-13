package com.javaboy.common.json;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 所有设备共有的属性
 *
 * @author peng
 * @date 2018/6/13
 */
@ApiModel
public class CommonConfig {
    @ApiModelProperty(value = "设备的其他自定义属性")
    List<OtherAttributeIn> otherAttributeIns;

    public List<OtherAttributeIn> getOtherAttributeIns() {
        return otherAttributeIns;
    }

    public void setOtherAttributeIns(List<OtherAttributeIn> otherAttributeIns) {
        this.otherAttributeIns = otherAttributeIns;
    }
}
