package com.javaboy.common.aop;

import com.javaboy.common.annotations.RateLimiter;
import com.javaboy.common.constant.CodeConstant;
import com.javaboy.common.exception.CustomException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * aop 对访问次数进行限流
 *
 * @author : zyf
 * @date : 2022/9/9 15:29
 */
@Aspect
@Component
public class RateLimiterAspect {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter) throws CustomException {
        int time = rateLimiter.time();
        int count = rateLimiter.count();
        long total;
        String combineKey = getCombineKey(rateLimiter, point);
        if (Boolean.TRUE.equals(redisTemplate.hasKey(combineKey))) {
            //请求进来，对应的key加1
            total = redisTemplate.opsForValue().increment(combineKey, 1);
            if (total > count) {
                throw new CustomException(CodeConstant.FAIL, rateLimiter.limitMsg());
            }
        } else {
            //初始化key
            redisTemplate.opsForValue().set(combineKey, 1, time, TimeUnit.SECONDS);
        }
    }

    public String getCombineKey(RateLimiter rateLimiter, JoinPoint point) {
        StringBuilder sb = new StringBuilder(rateLimiter.key());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        sb.append(targetClass.getName()).append("-").append(method.getName());
        return sb.toString();
    }


}
