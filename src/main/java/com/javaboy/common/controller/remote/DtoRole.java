package com.javaboy.common.controller.remote;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhangyafeng
 * @date 21/10/29
 * 系统用户前端参数封装与service和DAO层数据传输对象
 */
@Data
public class DtoRole implements Serializable {

    private String id;

    //角色名
    @ApiModelProperty(value = "角色名", required = true)
    @NotBlank(message = "角色名不能为空")
    private String roleName;

    private Integer pageNo;

    private Integer pageSize;

    private String name;
}
