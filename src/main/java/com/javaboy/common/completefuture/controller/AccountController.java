package com.javaboy.common.completefuture.controller;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.completefuture.dao.entity.Account;
import com.javaboy.common.completefuture.service.AccountService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zyf
 * @create: 2022-07-04 17:27
 **/
@RequiredArgsConstructor
@RequestMapping("/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    /**
     *
     * @param accountIdList [1,2,3]
     * @return
     */
    @ApiOperation("异步查询账户集合")
    @PostMapping("/list")
    public ResponseMsg<List<Account>> list(@RequestBody List<Integer> accountIdList) {
        return accountService.list(accountIdList);
    }
}
