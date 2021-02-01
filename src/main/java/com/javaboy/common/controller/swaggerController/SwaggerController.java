package com.javaboy.common.controller.swaggerController;

import com.github.pagehelper.PageInfo;
import com.javaboy.common.entity.Hero;
import com.javaboy.common.service.ThymelefService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author yayu
 * @title: SwaggerController
 * @description: TODO
 * @date 2021/1/28 13:49
 */
@RestController
@Api(tags = "查询接口")
@RequestMapping("/query")
public class SwaggerController {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerController.class);

    @Autowired
    private ThymelefService thymelefService;


    @GetMapping("/hero/{id}")
    @ApiOperation("查询英雄接口")
    @ApiImplicitParam(name = "id",value = "英雄id",dataType = "Integer")
    public PageInfo queryHero(@PathVariable("id") Integer id) {
        PageInfo<Hero> pageInfo = thymelefService.getByid(id);
        logger.info("查询成功~~~");
        return pageInfo;
    }

}
