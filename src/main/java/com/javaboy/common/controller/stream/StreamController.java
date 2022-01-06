package com.javaboy.common.controller.stream;

import com.javaboy.common.entity.Infomation;
import com.javaboy.common.service.StreamService;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * mybatis流查询接口
 */
@RequestMapping("/foo")
@RestController
public class StreamController {
    @Autowired
    private StreamService streamService;
    /**
     * 查询接口
     * @param limit 分页数量
     */
    @GetMapping("/query/{limit}")
    @Transactional
    public List<Infomation> scanFoo3(@PathVariable("limit") int limit) throws Exception {
        List<Infomation> list = new ArrayList<>();
        try (Cursor<Infomation> cursor = streamService.query(limit)) {
            cursor.forEach(foo -> list.add(foo));
        }
        return list;
    }


}
