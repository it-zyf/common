package com.javaboy.common.annotations;

import java.lang.annotation.*;

/**
 * @author : zyf
 * @date : 2022/9/9 15:18
 */
@Target(ElementType.METHOD) // 注解使用的元素
@Retention(RetentionPolicy.RUNTIME) //注解执行的阶段
@Documented
public @interface RateLimiter {
    /**
     * 限流key
     */
    String key() default "computer";

    /**
     * 限流时间,单位秒
     */
    int time() default 60;

    /**
     * 限流次数
     */
    int count() default 100;

    /**
     * 限流类型
     */
    String limitType() default "ip";

    /**
     * 限流后返回的文字
     */
    String limitMsg() default "访问过于频繁，请稍候再试";


}
