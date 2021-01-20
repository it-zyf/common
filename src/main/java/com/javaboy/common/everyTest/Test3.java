package com.javaboy.common.everyTest;

import cn.hutool.core.util.StrUtil;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * @author yayu
 * @title: Test3
 * @description: TODO
 * @date 2021/1/19 17:25
 */
public class Test3 {

    public static void main(String[] args) throws IOException {
       Test3.startProgram("P:\\learnProject\\common\\src\\main\\java\\com\\javaboy\\common\\util\\实达高拍仪websock模式\\Test\\StartWebServer.exe");


    }




    public static void startProgram(String programPath) throws IOException {
        ArrayList<String> list = new ArrayList<String>();
        if (StrUtil.isNotBlank(programPath)) {
            try {
                String programName = programPath.substring(programPath.lastIndexOf("/") + 1, programPath.lastIndexOf("."));
                list.add("cmd.exe");
                list.add("/c");
                list.add("start");
                list.add("\"" + programName + "\"");
                list.add("\"" + programPath + "\"");
                ProcessBuilder pBuilder = new ProcessBuilder(list);
                pBuilder.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }




// 第一种方式：利用cmd方式
    /**
     * 执行cmd命令
     *
     * @param command
     * @throws IOException
     */
    public static String executeCmd(String command) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("cmd /c " + command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
        String line = null;
        StringBuilder build = new StringBuilder();
        while ((line = br.readLine()) != null) {
            build.append(line);
        }
        return build.toString();
    }

}
