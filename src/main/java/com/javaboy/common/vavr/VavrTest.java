package com.javaboy.common.vavr;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.javaboy.common.entity.User;
import io.vavr.API;
import io.vavr.Tuple;
import io.vavr.Tuple1;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
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
        //一元组
        Tuple1<Integer> one = Tuple.of(1);
        Integer integer = one._1;
        System.out.println(integer);
        //二元组
        Tuple2<String, Integer> zhangsan = Tuple.of("zhangsan", 20);
        String s = zhangsan._1;
        Integer age = zhangsan._2;
        System.out.println(s + age);

        //lombok var
        var all = Tuple.of(1, "2", List.of(1, 2, 3), new User());
        Integer integer1 = all._1;
        List<Integer> integers = all._3();
        System.out.println(integer1);
        System.out.println(integers);

        //元组配合模糊匹配
        API.Match(all).of(
        );

    }

    /**
     * Option
     */
    @Test
    public void test3() {
        var result = Option.of("hello")
                .map(str -> (String) null)
                .getOrElse(() -> "world");
        System.out.println(result);

//字符串转换成集合,放入一个元素.
        java.util.List<String> list = Option.of("vavr hello world")
                .map(String::toUpperCase)
                .toJavaList();
        System.out.println(list);

    }

    /**
     * Try
     */
    @Test
    public void test4(){
        Try.of(()->1+1)
                .andThen(r-> System.out.println(r))
                .onFailure(error-> System.out.println(error.getMessage()))
                .onSuccess(result-> System.out.println(result))
                .andFinally(()->{
                    System.out.println("运行最后结果....");
                });
    }





}
