package com.javaboy.common.util.copy;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

/**
 * @author 15735
 */
public class WrapperBeanCopier {

    public static <T> void copyProperties(Object source, T target) {
        BeanUtils.copyProperties(source, target);
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        T t;
        t = getInstance(targetClass);
        copyProperties(source, t);
        return t;
    }

    private static <T> T getInstance(Class<T> targetClass) {
        T t;
        try {
            t = targetClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(format("Create new instance of %s failed: %s", targetClass, e.getMessage()));
        }
        return t;
    }

    public static <T> List<T> copyPropertiesOfList(List<?> sourceList, Class<T> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> resultList = new ArrayList<>(sourceList.size());
        for (Object o : sourceList) {
            T t = getInstance(targetClass);
            copyProperties(o, t);
            resultList.add(t);
        }
        return resultList;
    }
}