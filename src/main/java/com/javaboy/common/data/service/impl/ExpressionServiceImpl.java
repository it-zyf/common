package com.javaboy.common.data.service.impl;

import com.javaboy.common.data.dao.entity.Emo;
import com.javaboy.common.data.dao.mapper.ExpressionMapper;
import com.javaboy.common.data.service.ExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-06-27 16:30
 **/
@Service
@RequiredArgsConstructor
public class ExpressionServiceImpl  implements ExpressionService {
    private final ExpressionMapper expressionMapper;
    @Override
    public String save(Map map) {
        expressionMapper.insert(Emo.builder().emo(((String) map.get("emo"))).build());
        return "ok";
    }
}
