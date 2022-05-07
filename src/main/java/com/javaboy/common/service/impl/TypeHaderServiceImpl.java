package com.javaboy.common.service.impl;

import com.javaboy.common.entity.HH;
import com.javaboy.common.mapper.TypeHaderMapper;
import com.javaboy.common.service.TypeHaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author yayu
 * @title: TypeHaderServiceImpl
 * @description:
 * @date 2021/3/3 17:01
 */
@Service
public class TypeHaderServiceImpl implements TypeHaderService {
    @Autowired
    private TypeHaderMapper typeHaderMapper;

    @Override
    public void addHH() {
        /*HH hh = HH.builder().name("xyy").honor(Arrays.asList("王者", "吃鸡")).build();*/
        typeHaderMapper.addHH(null);

    }

    @Override
    public List<HH> sel() {
      return   typeHaderMapper.sel();
    }
}
