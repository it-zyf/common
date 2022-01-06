package com.javaboy.common.controller.easyExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

/**
 * @author: zyf
 * @create: 2022-01-06 16:44
 **/
@Data
public class FunctionMenu {
    @ExcelProperty("ID")
    @ColumnWidth(10)
    private Integer id;

    @ExcelProperty("PID")
    @ColumnWidth(10)
    private Integer pid;

    @ExcelProperty("名称")
    @ColumnWidth(10)
    private String name;

    @ExcelProperty("备注")
    @ColumnWidth(10)
    private String remark;

    @ExcelProperty("状态")
    @ColumnWidth(10)
    private Integer status;

}
