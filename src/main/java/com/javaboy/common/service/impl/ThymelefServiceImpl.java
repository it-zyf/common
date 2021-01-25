package com.javaboy.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaboy.common.entity.Hero;
import com.javaboy.common.entity.Infomation;
import com.javaboy.common.entity.Show;
import com.javaboy.common.mapper.ThymelefMapper;
import com.javaboy.common.service.ThymelefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author yayu
 * @title: ThymelefServiceImpl
 * @description: TODO
 * @date 2021/1/8 15:13
 */
@Service
public class ThymelefServiceImpl implements ThymelefService {
    @Autowired
    private ThymelefMapper thymelefMapper;

    @Override
    public PageInfo index(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize,"order by id desc");
        List<Hero> list = thymelefMapper.index();
        PageInfo<Hero> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<Infomation> infomation(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Infomation> list = thymelefMapper.infomation();
        PageInfo<Infomation> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Show show(Integer id) {
     Show show=thymelefMapper.show(id);
        return show;
    }
}
