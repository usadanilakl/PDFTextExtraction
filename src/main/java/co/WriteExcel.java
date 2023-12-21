package co;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
    public static String path = "LOTO.xlsx";
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static FileInputStream file;

    static{
        try {
            file = new FileInputStream(path);
            wb = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void write(String sheet, List<LinkedHashMap<String,String>> values){
        sh = wb.getSheet(sheet);
        int row = 2;
        for(Map<String,String> r : values){
            int column = 1;
            XSSFRow newRow = sh.createRow(row++);
           
            newRow.createCell(1).setCellValue(r.get("ID"));
            newRow.createCell(2).setCellValue(r.get("Description"));
            newRow.createCell(3).setCellValue(r.get("Location"));
            newRow.createCell(4).setCellValue(r.get("Equipment"));
            newRow.createCell(5).setCellValue(r.get("Type"));
            newRow.createCell(6).setCellValue(r.get("System"));
            newRow.createCell(7).setCellValue(r.get("P&ID"));
            newRow.createCell(8).setCellValue(r.get("Normal Pos"));
            newRow.createCell(9).setCellValue(r.get("Iso Pos"));
        
        }
        
        FileOutputStream fo;
        try {
            fo = new FileOutputStream(path);
            wb.write(fo);

            fo.close();
            wb.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

    }
    
    
}
