package com.javaboy.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaboy.common.controller.page.Teacher;
import com.javaboy.common.mapper.MybatisMapper;
import com.javaboy.common.service.MybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yayu
 * @title: MybatisServiceImpl
 * @description:
 * @date 2022/1/16 14:43
 */
@Service
@RequiredArgsConstructor
public class MybatisServiceImpl implements MybatisService {

    private final MybatisMapper mybatisMapper;


    @Override
    public Map<String, Object> getAll(Teacher teacher) {
        PageHelper.startPage(teacher.getPageNo(),teacher.getPageSize());
       List<Teacher> list = mybatisMapper.getTeachers();
        PageInfo pageInfo=new PageInfo<>(list);
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("pageInfo", pageInfo);
        return map;
    }
}
