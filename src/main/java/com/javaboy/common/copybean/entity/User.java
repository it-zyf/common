package com.javaboy.common.copybean.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zyf
 * @create: 2022-06-13 15:24
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;

    private String  age;

    private Integer sex;

    private Boolean gay;

    private List<String> hobby;
}
