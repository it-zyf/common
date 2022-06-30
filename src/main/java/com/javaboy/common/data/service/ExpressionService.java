package com.javaboy.common.data.service;

import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-06-27 16:28
 **/
public interface ExpressionService {
    /**
     * 保存表情
     * @param map
     * @return
     */
    String save(Map map);

    /**
     * 查询表情
     * @return
     */
    String query();

}
