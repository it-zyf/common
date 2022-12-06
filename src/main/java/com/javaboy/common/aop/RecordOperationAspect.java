package com.javaboy.common.aop;

import com.alibaba.fastjson.JSON;
import com.javaboy.common.annotations.Covert;
import com.javaboy.common.annotations.RecordOperation;
import com.javaboy.common.entity.RecordOperationDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author zyf
 * @date 2022/12/6 16:39
 */
@Aspect
@Component
public class RecordOperationAspect {
    @Pointcut("@annotation(com.javaboy.common.annotations.RecordOperation)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        CompletableFuture.runAsync(()->{
            MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
            RecordOperation annotation = methodSignature.getMethod().getAnnotation(RecordOperation.class);
            Class<? extends Covert> covert = annotation.covert();
            try {
                Covert  logConvert = covert.newInstance();
                RecordOperationDto recordOperationDto = logConvert.cover(proceedingJoinPoint.getArgs()[0]);
                recordOperationDto.setDesc(annotation.desc());
                recordOperationDto.setResult(result.toString());
                System.out.println("insert log:{}"+ JSON.toJSON(recordOperationDto));

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        });
        return result;
    }
}
