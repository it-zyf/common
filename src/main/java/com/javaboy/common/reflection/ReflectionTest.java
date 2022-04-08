package com.javaboy.common.reflection;

import cn.hutool.core.util.ReflectUtil;
import com.javaboy.common.constant.PathConstant;
import com.javaboy.common.service.impl.AddUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

/**
 * @author: zyf
 * @create: 2022-03-23 11:15
 **/
@RestController
@RequestMapping("/reflection")
@Slf4j
public class ReflectionTest {
    @RequestMapping("/test")
    public void test() {
        AddUserServiceImpl addUserServiceImpl = ReflectUtil.newInstance(PathConstant.ADD_USER_SERVICE_IMPL);
        Field[] fields = addUserServiceImpl.getClass().getDeclaredFields();
        for (Field field : fields) {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (null != annotation) {
                System.out.println(field.getName());
            }

        }
    }
}
