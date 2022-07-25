package com.javaboy.common.mybatisjoin.controller;

import com.javaboy.common.mybatisjoin.service.MybatisJoinService;
import com.javaboy.common.mybatisjoin.service.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : zyf
 * @date : 2022/7/25 14:03
 */
@RestController
@RequestMapping("/join")
@RequiredArgsConstructor
public class MybatisJoinController {
    private final MybatisJoinService mybatisJoinService;

    @GetMapping("/findAll")
    public List<AccountDto> findAll(){
        return mybatisJoinService.findAll();
    }
}
