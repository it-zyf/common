package com.javaboy.common.alltest;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.javaboy.common.entity.Level;
import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author: zyf
 * @create: 2022-02-21 16:55
 **/
@RequestMapping("/test14")
@RestController
public class Test14 {
    @PostMapping("/hh")
    public void test(@RequestBody Level level){
        if(Optional.ofNullable(null).isPresent()){
            System.out.println("我是中国人");
        }
    }

    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            String s = IdUtil.simpleUUID();
            System.out.println(s);
        }
    }

    @Test
    public void test2(){
        Integer a =null;
        if(ObjectUtil.isNotNull(a)){
            System.out.println("hh");
        }
    }

}
