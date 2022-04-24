package com.javaboy.common.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zyf
 * @create: 2021-10-20 15:59
 **/
public class ReadUtil {
    private ReadUtil() {
    }

    /**
     * 读取文本为一个集合
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static List<String> getFileContext(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            List<String> list = new ArrayList<>();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.trim().length() > 0) {
                    list.add(str);
                }
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
        return Collections.emptyList();
    }
}
