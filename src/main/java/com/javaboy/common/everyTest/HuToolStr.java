package com.javaboy.common.everyTest;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author: zyf
 * @create: 2021-12-17 16:16
 **/
@SuppressWarnings({"rawtypes","unchecked"})
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
        String flag="4";

        String platformId = "1,2,3,4";
        String[] split = platformId.split(",");

        System.out.println(platformId.split(",").length);
        if(!platformId.contains(flag)){
            System.out.println("没有该平台权限");
        }
        int i = ArrayUtil.indexOf(split, flag);
        String roleId="98,99,100,101";
        System.out.println(roleId.split(",").length);
        String s = roleId.split(",")[i];
        System.out.println(s);


    }

    @Test
    public void test3(){
        String a = "";
        String b="123";
        boolean blank = CharSequenceUtil.isBlank(a);
        boolean blank1 = CharSequenceUtil.isBlank(b);
        System.out.println(blank);
        System.out.println(blank1);

    }


}
