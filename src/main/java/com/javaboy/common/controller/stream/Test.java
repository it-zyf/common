package com.javaboy.common.controller.stream;

import com.javaboy.common.entity.Person;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author: zyf
 * @create: 2022-03-11 14:16
 **/
public class Test {
    @org.junit.Test
    public void test(){
        Person p1 = new Person(1l, "jack");
        Person p2 = new Person(3l, "jack chou");
        Person p3 = new Person(2l, "tom");
        Person p4 = new Person(4l, "hanson");
        Person p5 = new Person(5l, "胶布虫");

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p5, p1, p2, p2);


        // 方法1:根据id去重
        List<Person> unique = persons.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Person::getId))), ArrayList::new)
        );

        System.out.println(unique);
        //方法2:remove duplicate
        List<Person> collect = persons.stream().filter(distinctByKey(Person::getId)).collect(Collectors.toList());
        System.out.println(collect);


    }


    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
