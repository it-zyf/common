package com.javaboy.common.asnyctool.test;

import com.javaboy.common.asnyctool.PartWorkOne;
import com.javaboy.common.asnyctool.PartWorkThree;
import com.javaboy.common.asnyctool.PartWorkTwo;
import com.jd.platform.async.executor.Async;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;

import java.util.concurrent.ExecutionException;

/**
 * @author zyf
 * @date 2023/9/27 15:09
 */
public class MyAsyncWork1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        PartWorkOne w = new PartWorkOne();
        PartWorkTwo w1 = new PartWorkTwo();
        PartWorkThree w2 = new PartWorkThree();

        WorkerWrapper<String, String> workerWrapper2 =  new WorkerWrapper.Builder<String, String>()
                .worker(w2)
                .callback(w2)
                .param("2")
                .build();

        WorkerWrapper<String, String> workerWrapper1 =  new WorkerWrapper.Builder<String, String>()
                .worker(w1)
                .next(workerWrapper2)
                .callback(w1)
                .param("1")
                .build();

        WorkerWrapper<String, String> workerWrapper =  new WorkerWrapper.Builder<String, String>()
                .worker(w)
                .next(workerWrapper2)
                .callback(w)
                .param("0")
                .build();
        Async.beginWork(1500, workerWrapper, workerWrapper1);
        WorkResult<String> workResult = workerWrapper.getWorkResult();
        String result = workResult.getResult();
        System.out.println(result);

        Async.shutDown();

    }
}
