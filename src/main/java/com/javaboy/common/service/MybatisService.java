package com.javaboy.common.service;

import com.javaboy.common.controller.page.Teacher;

import java.util.Map;

/**
 * @author yayu
 * @title: Mybatisservice
 * @description: TODO
 * @date 2022/1/16 14:42
 */
public interface MybatisService {
    /**
     * 查询全部
     * @param teacher
     * @return
     */
    Map<String, Object> getAll(Teacher teacher);
}
