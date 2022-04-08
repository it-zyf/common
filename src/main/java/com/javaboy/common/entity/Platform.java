package com.javaboy.common.entity;

import lombok.Data;

/**
 * @author: zyf
 * @create: 2022-01-13 17:39
 **/
@Data
public class Platform {

    private String  id;

    private String userId;

    private String platform;

    private String roleId;

    private String organizationId;

    private Integer isLeader;



}
