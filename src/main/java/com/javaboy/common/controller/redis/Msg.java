package com.javaboy.common.controller.redis;

import com.javaboy.common.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: zyf
 * @create: 2022-04-02 15:11
 **/
@Data
public class Msg implements Serializable {
    private User user;
    private String flag;
}
