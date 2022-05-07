package com.javaboy.common.service;

import com.github.pagehelper.PageInfo;
import com.javaboy.common.entity.Hero;
import com.javaboy.common.entity.Infomation;
import com.javaboy.common.entity.Show;

/**
 * @author yayu
 * @title: ThymelefService
 * @description:
 * @date 2021/1/8 15:13
 */
public interface ThymelefService {
    PageInfo index(Integer pageNum,Integer pageSize);

    PageInfo<Infomation> infomation(Integer pageNum,Integer pageSize);

    Show show(Integer id);

    PageInfo<Hero> getByid(Integer id);
}
