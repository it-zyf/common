package com.javaboy.common.entity;

import lombok.Data;

/**
 * @author: zyf
 * @create: 2022-01-13 16:52
 **/
@Data
public class RoleDto {

    private String id;

    private String platform;

    private String roleId;

    private String organizationId;

    private Integer isLeader;

    private String userId;


}
