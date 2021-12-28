package com.javaboy.common.xxl.task;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

/**
 * @author: zyf
 * @create: 2021-12-24 15:40
 **/
@Component
public class XxlTask {
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("big")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
        System.out.println("你是猪");
    }

    @XxlJob("time")
    public void LookTime(){
        XxlJobHelper.log("START TASK!");
        System.out.println("RUN TIME");
    }

    @XxlJob("kingJunk")
    public void kingJunk(){
        XxlJobHelper.log("START TASK!");
        System.out.println("Then King Is Junk!");
    }


}
