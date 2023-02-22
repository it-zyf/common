package com.javaboy.common.vavr;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import io.vavr.collection.List;
import org.junit.Test;

import java.util.Objects;

/**
 * @author zyf
 * @date 2023/2/22 15:33
 */
public class VavrTest {

    /**
     * 集合
     */
    @Test
    public void test() {

        //静态方法添加元素,过滤(java9)
        List<String> filter = List.of("1", "123", "222", "").filter(StrUtil::isNotBlank);
        System.out.println(filter);

        //追加元素生成新的集合
        List<String> append = filter.append("1");
        System.out.println(append);

        //转换为java集合
        java.util.List<String> list = append.toJavaList();
        System.out.println(JSONObject.toJSONString(list));


        //集合中find查找数据,没有找到会报错.
        String s = append.find(l -> Objects.equals(l, "223")).getOrElseThrow(() -> new RuntimeException("没有"));
        System.out.println(s);

    }

    /**
     * 元组
     */
    @Test
    public void test2() {

    }


}
