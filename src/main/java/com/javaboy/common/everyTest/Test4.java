package com.javaboy.common.everyTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yayu
 * @title: Test4
 * @description: TODO
 * @date 2021/1/20 13:32
 */
@RequestMapping("/test")
@RestController
public class Test4 {
    /**
     * 启动扫描仪依赖下载
     */
    @RequestMapping("/imgDepDowLoad")
    public void downloadLocal(HttpServletResponse response) throws FileNotFoundException {
        // 下载本地文件
        String fileName = "P:\\learnProject\\common\\src\\main\\java\\com\\javaboy\\common\\util\\photo\\dependent.zip"; // 文件的默认保存名
        // 读到流中
        InputStream inStream = new FileInputStream(fileName);// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + "dependent.zip" + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
