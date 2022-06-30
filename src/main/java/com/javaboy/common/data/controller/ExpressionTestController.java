package com.javaboy.common.data.controller;

import com.javaboy.common.data.service.ExpressionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: zyf
 * @create: 2022-06-27 16:28
 **/
@RestController
@RequestMapping("/expression")
@RequiredArgsConstructor
public class ExpressionTestController {

    private final ExpressionService expressionService;

    @PostMapping("/save")
    public String expression(@RequestBody Map map){
        return expressionService.save(map);
    }

    @GetMapping("/query")
    public String query(){
        return expressionService.query();
    }


}
