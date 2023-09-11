package com.javaboy.common.copybean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-06-13 15:23
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private String userName;

    private String  age;

    private Boolean gay;

    private Integer sex;

    private List<String> hobby;

    private Map map;
}
