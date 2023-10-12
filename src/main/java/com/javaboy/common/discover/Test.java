package com.javaboy.common.discover;

/**
 * @author zyf
 * @date 2023/10/12 15:57
 */
public class Test {
    public static void main(String[] args) {
        ExcuteDiscover excuteDiscover = new ExcuteDiscover();
        String title = excuteDiscover.getTitle("chat");
        System.out.println(title);
    }
}
