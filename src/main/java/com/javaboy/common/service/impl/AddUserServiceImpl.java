package com.javaboy.common.service.impl;


import cn.hutool.core.lang.Snowflake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.javaboy.common.entity.Infomation;
import com.javaboy.common.mapper.AddUserMapper;
import com.javaboy.common.service.AddUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yayu
 * @title: AddUserServiceImpl
 * @description:
 * @date 2020/9/1716:33
 */
@Service
public class AddUserServiceImpl implements AddUserService {
    @Autowired
    private AddUserMapper adduserMapper;
    @Autowired
    private Snowflake snowflake;



    @Override
    public Map addUser() {
        Infomation infomationg = Infomation.builder()
                .age(12)
                .name("xyy")
                .sex("男")
                .photo("C:\\Users\\yayu\\Pictures\\Camera Roll\\46509166.jpg")
                .id(String.valueOf(snowflake.nextId()))
                .time(new Date())
                .build();
        adduserMapper.addStudent(infomationg);
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("code",200);
        map.put("msg","操作成功");
        return map;
    }

    @Override
    public int hh() {
//        HH hh = HH.builder().name("娜可露露").build();
//        int i = adduserMapper.hh(hh);
//        if(i==1){
//            Integer id = hh.getId();
//            return id;
//        }
        return 0;
    }

    @Override
    public PageInfo query(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Infomation> list = adduserMapper.query();
        PageInfo pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}
