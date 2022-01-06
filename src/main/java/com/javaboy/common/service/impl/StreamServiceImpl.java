package com.javaboy.common.service.impl;

import com.javaboy.common.entity.Infomation;
import com.javaboy.common.mapper.StreamMapper;
import com.javaboy.common.service.StreamService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zyf
 * @create: 2022-01-05 10:12
 **/
@Service
public class StreamServiceImpl implements StreamService {
    @Autowired
    private StreamMapper streamMapper;

    @Override
    public Cursor<Infomation> query(int limit) {
        return streamMapper.query(limit);
    }
}
