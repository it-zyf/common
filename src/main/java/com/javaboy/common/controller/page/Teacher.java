package com.javaboy.common.controller.page;

import lombok.Data;

import java.util.List;

/**
 * @author yayu
 * @title: Teacher
 * @description: TODO
 * @date 2022/1/16 14:45
 */
@Data
public class Teacher {
    private Integer id;

    private String name;


    List<Student> list;

    private Integer pageNo;

    private Integer pageSize;
}
