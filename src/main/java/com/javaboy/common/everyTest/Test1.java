package com.javaboy.common.everyTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author yayu
 * @title: Test
 * @description: TODO
 * @date 2021/1/18 14:20
 */
@Controller
@RequestMapping("/test")
public class Test1 {
    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public static void main(String[] args) {
       String base64 = "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";
        generateImage(base64, "g:\\b.jpg");
//        System.out.println(Test.getImageBinary());
Test1.base64StringToImage("");
    }

    static void base64StringToImage(String base64String) {
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String.replaceAll("\r\n", ""));
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File f1 = new File("g://out.jpg");
            ImageIO.write(bi1, "jpg", f1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static String getImageBinary() {
        File f = new File("g://微信图片_20210119162202.jpg");
        try {
            BufferedImage bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(imgStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
