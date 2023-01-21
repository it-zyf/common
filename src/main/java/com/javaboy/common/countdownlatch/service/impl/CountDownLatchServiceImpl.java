package com.javaboy.common.countdownlatch.service.impl;

import cn.hutool.core.util.StrUtil;
import com.javaboy.common.countdownlatch.entity.DownLatchCheck;
import com.javaboy.common.countdownlatch.service.CountDownLatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author zyf
 * @date 2023/1/21 11:10
 */
@Service
@Slf4j
public class CountDownLatchServiceImpl implements CountDownLatchService {

    @Override
    public List<DownLatchCheck> checkLongNum() {
        log.info("============================准备xxx工作前数据校验============");
        final List<DownLatchCheck> checks = Collections.synchronizedList(new ArrayList<>(0));
        //count的值必须跟异步任务个数对应上
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //校验名称.
        CompletableFuture.supplyAsync(() -> checkName("张三")).thenAccept(check -> {
            if (null != check) {
                checks.add(check);
            }
            countDownLatch.countDown();
        });
        //校验年龄.
        CompletableFuture.supplyAsync(() -> checkAge(18)).thenAccept(check -> {
            if (null != check) {
                checks.add(check);
            }
            countDownLatch.countDown();
        });
        //校验性别
        CompletableFuture.supplyAsync(() -> checkSex("女")).thenAccept(check -> {
            if (null != check) {
                checks.add(check);
            }
            countDownLatch.countDown();
        });
        //等待所有的执行结果.
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        return checks;
    }

    private DownLatchCheck checkSex(String sex) {
        if(StrUtil.isBlank(sex)){
            return   DownLatchCheck.builder().msg("性别不能为空").data("对应的数据====").build();
        }
        if(!"女".equals(sex)){
            return DownLatchCheck.builder().msg("性别不正确").data("对应的数据====").build();
        }
        return null;
    }

    private DownLatchCheck checkAge(Integer  age) {
        if(null==age){
            return   DownLatchCheck.builder().msg("年龄不能为空").data("对应的数据====").build();
        }
        if(age<18){
            return DownLatchCheck.builder().msg("年龄不符合要求").data("对应的数据====").build();
        }
        return null;
    }


    private DownLatchCheck checkName(String name){
       if(StrUtil.isBlank(name)){
         return   DownLatchCheck.builder().msg("用户名不能为空").data("对应的数据====").build();
       }
       if(!name.startsWith("Z")){
           return DownLatchCheck.builder().msg("格式不正确").data("对应的数据====").build();
       }
       return null;
    }
}
