package com.javaboy.common.asnyctool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.SystemClock;
import com.jd.platform.async.callback.ICallback;
import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;

import java.util.Map;

/**
 * @author zyf
 * @date 2023/9/27 14:53
 */
public class PartWorkTwo implements IWorker<String,String> , ICallback<String,String> {
    @Override
    public String action(String s, Map<String, WorkerWrapper> map) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result = " + SystemClock.now() + "---param = " + s  + " from 2";
    }

    @Override
    public String defaultValue() {
        return "worker2--default";
    }

    @Override
    public void begin() {
        System.out.println("任务2开始执行----------"+ DateUtil.now());
    }

    @Override
    public void result(boolean success, String param, WorkResult<String> workResult) {
        if (success) {
            System.out.println("callback worker2 success--" + SystemClock.now() + "----" + workResult.getResult()
                    + "-threadName:" +Thread.currentThread().getName());
        } else {
            System.err.println("callback worker2 failure--" + SystemClock.now() + "----"  + workResult.getResult()
                    + "-threadName:" +Thread.currentThread().getName());
        }
    }

    }