package com.javaboy.common.completefuture.service.impl;

import com.javaboy.common.api.ResponseMsg;
import com.javaboy.common.completefuture.dao.entity.Account;
import com.javaboy.common.completefuture.dao.mapper.AccountMapper;
import com.javaboy.common.completefuture.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
public class AccountServiceImpl  implements AccountService {

    private final  AccountMapper accountMapper;

    @Override
    public ResponseMsg<List<Account>> list(List<Integer> accountIdList) {

        //并行根据accountId找到account
        List<CompletableFuture<Account>> accountFindingFutureList =
                accountIdList.stream().map(accountId->findAccount(accountId)).collect(Collectors.toList());

        CompletableFuture<Void> allFutures =
                CompletableFuture
                        .allOf(accountFindingFutureList.toArray(new CompletableFuture[accountFindingFutureList.size()]));

        CompletableFuture<List<Account>> finalResults = allFutures.thenApply(v -> accountFindingFutureList.stream().map(accountFindingFuture ->
                        accountFindingFuture.join())
                .collect(Collectors.toList()));

        try {
            return new ResponseMsg<>(finalResults.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseMsg<>();
    }

    private CompletableFuture<Account> findAccount(Integer accountId){
        return CompletableFuture.supplyAsync(()->{
            try{
                System.out.println(Thread.currentThread().getName());
            }catch(Exception e){
                e.printStackTrace();
            }
            return  accountMapper.selectById(accountId);
        });
    }
}
