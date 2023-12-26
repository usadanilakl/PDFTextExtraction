package co.comparing_files;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;
import co.TextSortingMethods;

public class MyWithOldCopy {
    /*
    1.Find ID match - combine all info together to compare viually
    2. Store mismatches in separate file
     */

    public static void main(String[] args) {
        ExcelUtil my = new ExcelUtil("LOTOJ.xlsx", "MyList");
        List<LinkedHashMap<String, String>> allMy = my.getDataList();

        ExcelUtil old = new ExcelUtil("LOTOJ.xlsx", "OLD LOTO");
        List<LinkedHashMap<String, String>> allOld = old.getDataList();

        ExcelUtil vend = new ExcelUtil("LOTOJ.xlsx", "Vendor");
        List<LinkedHashMap<String, String>> allVend = vend.getDataList();

        List<LinkedHashMap<String,String>> mismatch = new ArrayList<>();

        for(LinkedHashMap<String,String> s : allOld){
            s.put("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")+""));
        }

        for(LinkedHashMap<String,String> s : allVend){
            s.put("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")+""));
        }

        for(LinkedHashMap<String,String> s : allMy){
            s.put("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")+""));
        }

        List<LinkedHashMap<String,String>> combined = new ArrayList();

        System.out.println("allMy.get(0) = " + allMy.get(1000).get("ID"));
        System.out.println("allMy.get(0) = " + allVend.get(1000).get("ID"));

       // WriteExcel.write("Sheet1", combined);
        //WriteExcel.write("Sheet2", mismatch);
        
    }
}
