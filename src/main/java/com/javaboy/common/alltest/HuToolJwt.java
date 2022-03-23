package com.javaboy.common.alltest;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * hutool工具类jwt测试
 *
 * @author: zyf
 * @create: 2021-11-16 18:19
 **/
public class HuToolJwt {
    /**
     * 创建token
     *
     * @return
     */
    public String create() {
        Map<String, Object> map = new HashMap<String, Object>(3) {
            private static final long serialVersionUID = 1L;

            {
                put("uid", Integer.parseInt("123"));
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
                put("roleId", 1);
            }
        };

        return JWTUtil.createToken(map, "1234".getBytes());
    }

    /**
     * 解析token
     */
    @Test
    public void parse() {
        String rightToken = this.create();
        System.out.println(rightToken);
        final JWT jwt = JWTUtil.parseToken(rightToken);
        Object uid = jwt.getPayload("uid");
        Object roleId = jwt.getPayload("roleId");
    }

    /**
     * 验证token
     */
    @Test
    public void verify() {
        String rightToken = this.create();
        boolean verify = JWTUtil.verify(rightToken, "1234".getBytes());
        System.out.println(verify);
    }


}
