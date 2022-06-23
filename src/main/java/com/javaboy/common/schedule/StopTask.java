package com.javaboy.common.schedule;

import io.lettuce.core.dynamic.support.ReflectionUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Component;

/**
 * @author: zyf
 * @create: 2022-06-22 16:19
 **/
@Component
@Slf4j
@RequiredArgsConstructor
public class StopTask {

    private final CustomTaskScheduler customTaskScheduler;

    private int count;

    //@Scheduled(cron = "*/5 * * * * ?")
    public void stopTask() {
        count++;
        log.info("--------------------------执行内容----------------------------------------------");
        if (count > 3) {
            log.info("任务已执行指定次数，现在自动停止");
            boolean cancelled = customTaskScheduler.getScheduledTasks().get(this).cancel(true);

            // 停止后再次启动
            if (cancelled) {
                count = 0;
                ScheduledMethodRunnable runnable = new ScheduledMethodRunnable(this, ReflectionUtils.findMethod(this.getClass(), "stopTask"));
                customTaskScheduler.schedule(runnable, new CronTrigger("*/1 * * * * *"));
            }
        }
    }
}
