package com.javaboy.common.alltest;

import java.io.*;

/**
 * @author yayu
 * @title: Test5
 * @description:
 * @date 2021/1/21 15:07
 */
public class Test5 {
    public static void main(String[] args) throws IOException {
        InputStream srcStream= new FileInputStream("C:\\Users\\yayu\\Pictures\\Camera Roll\\46509166.jpg");
        File file = new File("g:\\123.jpg");
        OutputStream fops = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buf = new byte[1024];
        int numBytesRead = 0;
        while ((numBytesRead = srcStream.read(buf)) != -1) {
            fops.write(buf, 0, numBytesRead);
        }
        fops.flush();
        fops.close();
    }
}
