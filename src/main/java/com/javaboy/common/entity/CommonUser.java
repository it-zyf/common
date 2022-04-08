package com.javaboy.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author: zyf
 * @create: 2022-03-10 14:44
 **/
@Data
@Accessors(chain = true)
public class CommonUser implements Serializable {

    private String id;

    private String username;

    private String name;
}
