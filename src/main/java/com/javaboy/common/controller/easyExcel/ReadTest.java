package com.javaboy.common.controller.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.javaboy.common.util.LocalJsonUtil;
import com.javaboy.common.util.TestFileUtil;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author: zyf
 * @create: 2021-12-31 14:50
 **/
@Controller
@RequestMapping("/easyExcel")
public class ReadTest {
    @RequestMapping("/test")
    public void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                System.out.println("读取到一条数据{}"+ JSON.toJSONString(demoData));
            }
        })).sheet().doRead();
    }


    @SneakyThrows(IOException.class)
    @ApiOperation(value = "导出会员列表Excel")
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public void exportMemberList(HttpServletResponse response) {
        setExcelRespProp(response, "会员列表");
        List<FunctionMenu> memberList = LocalJsonUtil.getListFromJson("json/members.json", FunctionMenu.class);
        EasyExcel.write(response.getOutputStream())
                .head(FunctionMenu.class)
                .excelType(ExcelTypeEnum.XLSX)
                .sheet("会员列表")
                .doWrite(memberList);
    }


    /**
     * 设置excel下载响应头属性
     */
    private void setExcelRespProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }



}
