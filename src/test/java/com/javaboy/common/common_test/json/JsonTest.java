package com.javaboy.common.common_test.json;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author zyf
 * @date 2023/8/9 18:03
 */
public class JsonTest {

    @Test
    public void test(){

        String a ="{\"auth\":{\"vendorName\":\"nsfocus\",\"authCenterType\":\"ESPC-L\",\"deviceType\":\"RSAS\",\"version\":\"V6.0R04F02\",\"defaultAuthModelName\":\"10_SysScan_WebScan_bvs\"}}";

        cn.hutool.json.JSON parse = JSONUtil.parse(a);

        Object auth = parse.getByPath("auth");

        String s = auth.toString();

        DeviceAuthEvent.AuthData authData = JSONUtil.toBean(s,DeviceAuthEvent.AuthData.class);

        System.out.println(JSON.toJSONString(authData,true));
    }

    @Test
    public void test2(){
        TestH user = new TestH();
        int age = user.getAge();
        System.out.println(age);
        System.out.println(age+1);
    }
}
