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
public class PartWorkOne implements IWorker<String,String> , ICallback<String,String> {
    @Override
    public String action(String s, Map<String, WorkerWrapper> map) {
        try {
            System.out.println("这是map参数:{}"+map);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "result = " + SystemClock.now() + "---param = "  + s +" from 1";
    }

    @Override
    public String defaultValue() {
        return "worker1--default";
    }

    @Override
    public void begin() {
        System.out.println("任务1开始执行----------"+ DateUtil.now());
    }

    @Override
    public void result(boolean success, String param, WorkResult<String> workResult) {
        if (success) {
            System.out.println("callback worker1 success--" + SystemClock.now() + "----" + workResult.getResult()
                    + "-threadName:" +Thread.currentThread().getName());
        } else {
            System.err.println("callback worker1 failure--" + SystemClock.now() + "----"  + workResult.getResult()
                    + "-threadName:" +Thread.currentThread().getName());
        }
    }

}