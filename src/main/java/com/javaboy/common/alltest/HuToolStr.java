package com.javaboy.common.alltest;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.javaboy.common.entity.Platform;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: zyf
 * @create: 2021-12-17 16:16
 **/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HuToolStr {
    /**
     * 模板使用
     */
    @Test
    public void test() {
        String code = "123";
        String template = "尊敬的安全研究员，感谢您的耐心等待，很遗憾，暂时无法通过您的入驻平台申请，理由为【{}】。如有其他问题，随时与我们联系！";
        String str = StrUtil.format(template, code);
        System.out.println(str);
    }

    @Test
    public void test2() {
        String flag = "4";

        String platformId = "1,2,3,4";
        String[] split = platformId.split(",");

        System.out.println(platformId.split(",").length);
        if (!platformId.contains(flag)) {
            System.out.println("没有该平台权限");
        }
        int i = ArrayUtil.indexOf(split, flag);
        String roleId = "98,99,100,101";
        System.out.println(roleId.split(",").length);
        String s = roleId.split(",")[i];
        System.out.println(s);


    }

    @Test
    public void test3() {
        String a = "";
        String b = "123";
        boolean blank = CharSequenceUtil.isBlank(a);
        boolean blank1 = CharSequenceUtil.isBlank(b);
        System.out.println(blank);
        System.out.println(blank1);

    }

    @Test
    public void test4() {
        String s = IdUtil.simpleUUID();
        System.out.println(s);
    }


    @Test
    public void test5() {
        ArrayList<Platform> list = new ArrayList<>();
        Platform platform = new Platform();
        platform.setId("123");
        platform.setIsLeader(1);
        platform.setRoleId("1231");
        platform.setUserId("hhhhh");
        list.add(platform);

        ArrayList<Platform> list2 = new ArrayList<>();
        Platform roleDto = new Platform();
//        roleDto.setId("123");
//        roleDto.setIsLeader(1);
//        roleDto.setRoleId("1231");
//        roleDto.setUserId("hhhhh");
//        Platform roleDto1 = new Platform();

        list2.add(roleDto);
//        list2.add(roleDto1);


//        boolean disjoint = Collections.disjoint(list, list2);
        //两个对象集合一样没有值
        Collection<Platform> disjunction = CollUtil.disjunction(list, list2);
        System.out.println(disjunction);
    }


}
