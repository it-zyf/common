package com.javaboy.common.controller.easypoi;

import com.javaboy.common.entity.User3;
import com.javaboy.common.util.FileWithExcelUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yayu
 * @title: TestEasyPoi
 * @description:
 * @date 2021/6/10 10:30
 */
@RestController
@RequestMapping("/import")
public class TestEasyPoi {
    /**
     * 导入excel
     */
    @PostMapping("/importExcelForType")
    public Map<String, Object> importExcel(@RequestParam("file") MultipartFile file) {
        try {
//          String filePath = "/Users/***/Downloads/response.xls";
            //解析excel，
//          List<CustomerList> personList = FileWithExcelUtil.importExcel(filePath, 1, 1, CustomerList.class);
            List<User3> personList = FileWithExcelUtil.importExcel(file, 1, 1, User3.class);
            //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
            System.out.println("导入数据一共【" + personList.size() + "】行");
            personList.forEach(pe -> System.out.println(pe));
//            for (int i = 0; i < personList.size(); i++) {
//                User3 excel = personList.get(i);
//                CmCustomerForExcel customer =  customerListByExcel(excel);
//                customer.setCustomerType(customerType);
//                customerService.saveExcelList(customer);
//            }
            return new HashMap<String, Object>() {{
                put("code", "111");
            }};

        } catch (Exception e) {
            //  : handle exception
            return new HashMap<String, Object>(1) {{
                put("code", "111");
            }};
        }


    }
}
