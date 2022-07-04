package com.javaboy.common.alltest;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author: zyf
 * @create: 2022-07-01 18:08
 **/
public class CompleteFutureTest {
    public static  int i=0;

    public static CompletableFuture<String> findAccount(String accountId){
        return CompletableFuture.supplyAsync(()->{
            try{
                System.out.println(Thread.currentThread().getName()+":start!");
                //Thread.sleep((++i)*1000);
                System.out.println(Thread.currentThread().getName()+":end!");
            }catch(Exception e){
                e.printStackTrace();
            }
            return "account"+accountId;
        });
    }

    public static void batchProcess(List<String> accountIdList) {
        //并行根据accountId找到account
        List<CompletableFuture<String>> accountFindingFutureList =
                accountIdList.stream().map(accountId->findAccount(accountId)).collect(Collectors.toList());

        System.out.println(accountFindingFutureList);
        //用allOf表示所有并行任务
        CompletableFuture<Void> allFutures =
                CompletableFuture
                        .allOf(accountFindingFutureList.toArray(new CompletableFuture[accountFindingFutureList.size()]));

        System.out.println(allFutures);

        CompletableFuture<List<String>> finalResults = allFutures.thenApply(v -> accountFindingFutureList.stream().map(accountFindingFuture ->
                        accountFindingFuture.join())
                .collect(Collectors.toList()));
        System.out.println(finalResults);

        try{
            List<String> l = finalResults.get();
            System.out.println(l);
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        List<String> list = Lists.newArrayList();
        list.add("11111");
        list.add("11112");
        list.add("11113");
        list.add("11114");
        batchProcess(list);
    }
}
