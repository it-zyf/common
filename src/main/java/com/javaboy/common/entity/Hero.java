package com.javaboy.common.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author yayu
 * @title: Hero
 * @description:
 * @date 2021/1/8 15:04
 */
@Data
@Builder
public class Hero {
    private Integer id;
    private String name;
    private String attribute;

}
