/*
package com.javaboy.common.everyTest;

import cn.hutool.core.util.IdUtil;
import com.javaboy.common.entity.User2;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author yayu
 * @title: ExcelImport
 * @description: TODO
 * @date 2021/6/8 14:32
 *//*

public class ExcelImport {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "D:\\测试.xlsx";
        String picStorePath = "D:\\";

        File file = new File(filePath);
        importExcelWithImage(new FileInputStream(file), file.getName(), picStorePath);

    }

    public static void importExcelWithImage(InputStream in, String fileName, String picStorePath) {
        Workbook workbook;
        Sheet sheet;
        //图片数据
        Map<String, PictureData> pictureDataMap = null;
        //得到工作簿
        try {
            if (fileName.endsWith(".xls")) {
                //2003版本的excel，用.xls结尾
                workbook = new HSSFWorkbook(in);
            } else if (fileName.endsWith(".xlsx")) {
                //2007版本的excel，用.xlsx结尾
                workbook = new XSSFWorkbook(in);
            } else {
                System.err.println("不支持的Excel格式！");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // ----- 获取图片数据 -----
        sheet = workbook.getSheetAt(0);
        // 判断用07还是03的方法获取图片
        if (fileName.endsWith(".xls")) {
            pictureDataMap = getXlsPictures((HSSFSheet) sheet);
        } else {
            pictureDataMap = getXlsxPictures((XSSFSheet) sheet);
        }

        // ----- 获得标题 -----
        Row rowHead = sheet.getRow(0);
        int rowHeadPhysicalNumberOfCells = rowHead.getPhysicalNumberOfCells();
//        for (int i = 0; i < rowHeadPhysicalNumberOfCells; i++) {
//            Cell cell = rowHead.getCell(i);
//            System.out.println(cell.getStringCellValue());
//        }

        // ----- 获取其他数据 -----
        int totalRowNum = sheet.getLastRowNum();
        List<User2> list = new ArrayList<>();
        for (int i = 1; i <= totalRowNum; i++) {
            User2 user2 = new User2();
            Row row = sheet.getRow(i);
            System.out.println(row.getCell(0).getStringCellValue());
            user2.setUser(row.getCell(0).getStringCellValue());
            double age = row.getCell(1).getNumericCellValue();
            user2.setAge((int) age);
            list.add(user2);
        }
        // ----- 输出图片 -----
        try {
            List<User2> list1 = printImg(pictureDataMap, picStorePath, list);
            list1.forEach(en -> System.out.println(en));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    */
/**
     * 获取图片和位置 (xls)
     *
     * @param sheet /
     * @return /
     *//*

    public static Map<String, PictureData> getXlsPictures(HSSFSheet sheet) {
        Map<String, PictureData> map = new HashMap<>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                // 行号-列号
                String key = cAnchor.getRow1() + "-" + cAnchor.getCol1();
                map.put(key, picture.getPictureData());
            }
        }
        return map;
    }

    */
/**
     * 获取图片和位置 (xlsx)
     *
     * @param sheet /
     * @return /
     *//*

    public static Map<String, PictureData> getXlsxPictures(XSSFSheet sheet) {
        Map<String, PictureData> map = new HashMap<>(4);
        XSSFRow row = sheet.getRow(1);
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    // 行号-列号
                    CTMarker marker = anchor.getFrom();
//                    String key = marker.getRow() + "-" + marker.getCol();
                    String uuid = IdUtil.simpleUUID();
                    String key = marker.getRow() + "_" + uuid;
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }


    */
/**
     * 输出图片
     *
     * @param pictureDataMap 图片信息
     * @param path           图片保存路径
     * @throws IOException /
     *//*

    public static List<User2> printImg(Map<String, PictureData> pictureDataMap, String path, List<User2> list) throws IOException {
        Object[] key = pictureDataMap.keySet().toArray();
        for (int i = 0; i < pictureDataMap.size(); i++) {
            // 获取图片索引
            String picIndex = key[i].toString();
            // 获取图片流
            PictureData pic = pictureDataMap.get(picIndex);
            // 获取图片格式
            String ext = pic.suggestFileExtension();
            byte[] data = pic.getData();
            //图片保存路径
            String imgPath = path + picIndex + "." + ext;
            FileOutputStream out = new FileOutputStream(imgPath);
            out.write(data);
            out.close();
            list.get(i).setPhoto(imgPath);
        }
        return list;
    }


}






*/
