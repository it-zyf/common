package com.javaboy.common.mapper;

import com.javaboy.common.controller.page.Student;
import com.javaboy.common.controller.page.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yayu
 * @title: AddUserMapper
 * @description: TODO
 * @date 2020/9/1716:34
 */
@Repository
public interface MybatisMapper {

    /**
     * 查询老师
     * @param page
     * @return
     */
    List<Teacher> getTeachers();

    /**
     * 查询学生
     * @param Teacher
     * @return
     */
    List<Student> getStudents(String Teacher);
}
