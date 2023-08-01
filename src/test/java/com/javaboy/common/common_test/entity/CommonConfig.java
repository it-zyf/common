package com.javaboy.common.common_test.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 所有设备共有的属性
 *
 * @author peng
 * @date 2018/6/13
 */
@ApiModel
@Data
public class CommonConfig {
    @ApiModelProperty(value = "设备的其他自定义属性")
    List<OtherAttributeIn> otherAttributeIns;
}
