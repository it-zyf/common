package com.javaboy.common.everyTest;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author: zyf
 * @create: 2021-12-17 16:16
 **/
public class HuToolStr {
    @Test
    public void test() {
        String code = "123";
        String template = "尊敬的安全研究员，感谢您的耐心等待，很遗憾，暂时无法通过您的入驻平台申请，理由为【{}】。如有其他问题，随时与我们联系！";
        String str = StrUtil.format(template, code);
        System.out.println(str);
    }


}
