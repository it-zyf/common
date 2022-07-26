package com.javaboy.common.alltest;

/**
 * @author : zyf
 * @date : 2022/7/26 15:28
 */
public class SingleTest {

    private static SingleTest singleTest;

    private SingleTest(){}

    public static synchronized SingleTest getSingleTest(){
        if(null == singleTest){
            singleTest=new SingleTest();
        }
        return singleTest;
    }
}
