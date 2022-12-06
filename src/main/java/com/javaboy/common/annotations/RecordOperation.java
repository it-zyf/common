package com.javaboy.common.annotations;

import java.lang.annotation.*;

/**
 * @author zyf
 * @date 2022/12/6 16:37
 */
@Target(ElementType.METHOD) // 注解使用的元素
@Retention(RetentionPolicy.RUNTIME) //注解执行的阶段
@Documented
public @interface RecordOperation {

    String desc() default "";

    Class<? extends Covert> covert();
}
