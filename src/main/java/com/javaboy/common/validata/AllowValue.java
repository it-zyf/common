package com.javaboy.common.validata;


import com.javaboy.common.validata.impl.AllowValueImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * zyf
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = AllowValueImpl.class)
public @interface AllowValue {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "not allow value";

    String value();

    boolean required() default false;
}
