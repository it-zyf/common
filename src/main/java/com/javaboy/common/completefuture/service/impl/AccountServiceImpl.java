package com.javaboy.common.completefuture.service.impl;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.completefuture.dao.entity.Account;
import com.javaboy.common.completefuture.dao.mapper.AccountMapper;
import com.javaboy.common.completefuture.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author: zyf
 * @create: 2022-07-04 17:31
 **/
@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    @Override
    public ResponseMsg<List<Account>> list(List<Integer> accountIdList) {

        //并行根据accountId找到account
        List<CompletableFuture<Account>> accountFindingFutureList =
                accountIdList.stream().map(this::findAccount).collect(Collectors.toList());

        CompletableFuture<Void> allFutures =
                CompletableFuture
                        .allOf(accountFindingFutureList.toArray(new CompletableFuture[accountFindingFutureList.size()]));

        CompletableFuture<List<Account>> finalResults = allFutures.thenApply(v -> accountFindingFutureList.stream().map(CompletableFuture::join)
                .collect(Collectors.toList()));

        try {
            return new ResponseMsg<>(finalResults.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("获取数据异常" + e.getMessage());
            Thread.currentThread().interrupt();
        }
        return new ResponseMsg<>();
    }

    @Override
    public List<String> queryAllList() {

        //异步查询第一个数据
        CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
            List<String> list = new ArrayList<>();
            list.add("zhangsan");
            return list;
        });
        //异步查询第二个数据
        CompletableFuture<List<String>> future1 = CompletableFuture.supplyAsync(() -> {
            List<String> list = new ArrayList<>();
            list.add("lisi");
            return list;
        });
        //阻塞异步完成
        CompletableFuture.allOf(future, future1).join();
        try {
            //整合数据
            List<String> listOne = future.get();
            List<String> listTwo = future1.get();
            listOne.addAll(listTwo);
            return listOne;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    private CompletableFuture<Account> findAccount(Integer accountId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return accountMapper.selectById(accountId);
        });
    }
}
