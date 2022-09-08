package com.javaboy.common.slidwindow;

/**
 * @author : zyf
 * @date : 2022/9/8 15:00
 */
public class Demo {



    public static void main(String[] args) {
        SlidingWindowDemo slidingWindowDemo = new SlidingWindowDemo();
        for (int i = 0; i < 10; i++) {
            boolean grant = slidingWindowDemo.grant();
            System.out.println(grant);
        }
    }
}
