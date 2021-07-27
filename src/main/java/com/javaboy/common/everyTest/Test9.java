package com.javaboy.common.everyTest;

import io.swagger.annotations.ApiOperation;
import org.apache.poi.util.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

public class Test9 {
    @ApiOperation(value = "配置Excel模板文件下载", notes = "配置Excel模板文件下载")
    @RequestMapping("/download")
    @ResponseBody
    public void download(HttpServletResponse response) throws Exception{
        response.setHeader("Content-Disposition", "attachment; filename=template.xlsx");
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("template.xlsx");
        IOUtils.copy(in,response.getOutputStream());
        in.close();
    }
}
