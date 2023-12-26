package co.comparing_files;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;
import co.TextSortingMethods;
import co.WriteExcel;

public class MyWithOld {
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

        for(LinkedHashMap<String,String> s : allMy){
            LinkedHashMap<String,String> one = new LinkedHashMap<>();
            boolean noMatch = true;
            for(LinkedHashMap<String,String> e : allVend){
                if(s.get("ID").contains(e.get("ID"))){
                    System.out.println("Success");
                    one.put("ID", s.get("ID"));
                    one.put("Description", s.get("Description"));
                    one.put("Location", s.get("Location"));
                    one.put("Equipment", s.get("Equipment"));
                    one.put("Extra Info", e.get("Extra Info"));
                    one.put("Type", e.get("Type"));
                    one.put("SystemV", e.get("System"));
                    one.put("SystemM", s.get("System"));
                    one.put("P&ID", e.get("P&ID"));
                    one.put("Normal Pos", s.get("Normal Pos"));
                    one.put("Iso Pos", s.get("Iso Pos"));
                    one.put("Fluid", s.get("Fluid"));
                    one.put("Size", s.get("Size"));
                    noMatch = false;
                }
                break;
            }
            combined.add(one);
            if(noMatch) mismatch.add(s);

        }

       // WriteExcel.write("Sheet1", combined);
        WriteExcel.write("Sheet2", mismatch);
        
    }
}
