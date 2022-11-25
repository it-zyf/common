package com.javaboy.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.util.CastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zyf
 * @date 2022/11/24 21:43
 */
public class Test {
    @org.junit.Test
    public void parseJson(){
         String json="{\n" +
                "    \"systemBindIdMap\": { \n" +
                "        \"HJGJ\": [\n" +
                "            \"00faefdfe39943118813e5b7d2a7a040\",\n" +
                "            \"09e5c19b3ea84148b9527698e2cb4b71\"\n" +
                "        ],\n" +
                "        \"KSHS\": [\n" +
                "            \"0feef36d47c0444da97caf0268b39c4a\",\n" +
                "            \"165f88c9bac34bbb9c66d05fffb2372e\"\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject systemBind = jsonObject.getJSONObject("systemBindIdMap");
        List<String> binds = CastUtils.cast(systemBind.get("123"));

        Optional.ofNullable(binds).ifPresent(bs-> Optional.ofNullable(getProjects(bs)).orElseGet(ArrayList::new).forEach(System.out::println));


        Optional.ofNullable(binds).orElseGet(ArrayList::new).forEach(System.out::println);

    }

    private List<String> getProjects(List<String> list){
        return list;
    }

}
