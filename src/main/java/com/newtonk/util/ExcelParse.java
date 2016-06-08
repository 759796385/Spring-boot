package com.newtonk.util;

import jxl.Cell;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by newtonk on 2016/5/31.
 */
public class ExcelParse {
    public static List<ExcelObject> start(InputStream file) {
        Sheet sheet;//页
        Workbook book;//excel
        Cell name;//单位格
        List<ExcelObject> excelObjectList = new ArrayList<ExcelObject>();
        try {
            // t.xls为要读取的excel文件名
            book = Workbook.getWorkbook(file);
            // 获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            // sheet = book.getSheet(0);
            // 获取左上角的单元格
            // name = sheet.getCell(0, 0);
            for (int j = 0; j < book.getNumberOfSheets() - 1; j++) {// 遍历每一页
                sheet = book.getSheet(j);
                for (int i = 1; i < sheet.getRows(); i++) {//遍历每一行
                    String member_name = sheet.getCell(0, i).getContents().trim();// （列，行）
                    if(member_name==null||member_name.length()==0){
                        continue;
                    }
                    String sex = sheet.getCell(1, i).getContents().trim();
                    String phone= sheet.getCell(2, i).getContents().trim();
                    String cardId = sheet.getCell(3, i).getContents().trim();

                    String birthday = formatDateToString(sheet.getCell(4, i),"yyyy/MM/dd");//time

                    String mail = sheet.getCell(5, i).getContents().trim();
                    String remarks = sheet.getCell(6, i).getContents().trim();
                    String mcCode = sheet.getCell(7, i).getContents().trim();
                    String cardTypeId = sheet.getCell(8, i).getContents().trim();
                    String cardLeftBalance = sheet.getCell(9, i).getContents().trim();
                    String cardLeftNum = sheet.getCell(10, i).getContents().trim();
                    Date createDay = formatDateToDate(sheet.getCell(11, i));//time
                    Date endDay = formatDateToDate(sheet.getCell(12, i));//time
                    String state =  sheet.getCell(13, i).getContents().trim();
                    ExcelObject excel = new ExcelObject(member_name,sex,phone,cardId,birthday,mail,remarks,mcCode,cardTypeId,cardLeftBalance,cardLeftNum,createDay,endDay,state);
                    excelObjectList.add(excel);
                }
            }
            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelObjectList;
    }

    public static String formatDateToString(Cell cell,String partten){
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        if(cell instanceof DateCell) {
            DateCell dateCell = (DateCell) cell;
            Date date = dateCell.getDate();
            return sdf.format(date);
        }
        return "";
    }
    public static Date formatDateToDate(Cell cell){
        if(cell instanceof DateCell) {
        DateCell dateCell = (DateCell) cell;
        return dateCell.getDate();
        }
        return null;
    }
}
