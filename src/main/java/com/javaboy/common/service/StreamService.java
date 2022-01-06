package com.javaboy.common.service;

import com.javaboy.common.entity.Infomation;
import org.apache.ibatis.cursor.Cursor;

/**
 * @author: zyf
 * @create: 2022-01-05 10:11
 **/
public interface StreamService {
    /**
     * mybatis流查询
     * @param limit
     * @return
     */
    Cursor<Infomation> query(int limit);
}
