package com.javaboy.common.controller.redis;

import com.javaboy.common.entity.User;
import lombok.Data;

/**
 * @author: zyf
 * @create: 2022-04-02 15:11
 **/
@Data
public class Msg {
    private User user;
    private String flag;
}
