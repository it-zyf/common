package com.javaboy.common.slidwindow;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 限流:基于滑动时间窗口
 *
 * @author : zyf
 * @date : 2022/9/8 14:46
 */
public class SlidingWindowDemo {
    /**
     * 时间窗口内最大请求数
     */
    private final int limit = 4;

    /**
     * 时间窗口1s
     */
    private final long interval = 1000;
    /**
     * 记录每个请求时间
     */
    private List<Long> reqTimes = new ArrayList<>();


    public SlidingWindowDemo() {
        reqTimes.add(getNowTime());
    }

    private long getNowTime() {
        return System.currentTimeMillis();
    }


    /**
     * 判断是否限流
     *
     * @return
     */
    public boolean grant() {

        long nowTime = getNowTime();

        if (CollUtil.isNotEmpty(reqTimes)) {

            if (nowTime < reqTimes.get(0) + interval) {
                if (reqTimes.size() <= limit) {
                    reqTimes.add(nowTime);
                    return true;
                }
                return false;
            } else {
                reqTimes.remove(0);
                return true;
            }

        }
        return false;

    }

}
