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
        List<LinkedHashMap<String,String>> combined = new ArrayList();

        for(LinkedHashMap<String,String> s : allOld){
            s.put("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")+""));
        }

        for(LinkedHashMap<String,String> s : allVend){
            s.put("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")+""));
        }

        for(LinkedHashMap<String,String> s : allMy){
            s.put("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")+""));
        }

        System.out.println("allMy size: " + allMy.size());
        System.out.println("allOld size: " + allOld.size());
        System.out.println("allVend = " + allVend.size());
        int matched = 0;

        for(LinkedHashMap<String,String> s : allOld){
            LinkedHashMap<String,String> one = new LinkedHashMap<>();
            boolean noMatch = true;
            for(LinkedHashMap<String,String> e : allMy){
                if(s.get("ID").equals(e.get("ID"))&&s.get("ID")!=null){
                    //System.out.println("Success");
                    one.put("ID", s.get("ID"));
                    one.put("Description", e.get("Description"));
                    one.put("Location", e.get("Location"));
                    one.put("Equipment", e.get("Equipment"));
                    one.put("Extra Info", s.get("Description"));
                    one.put("Type", e.get("Type"));
                    one.put("System", e.get("System"));
                    //one.put("SystemM", s.get("System"));
                    one.put("P&ID", e.get("P&ID"));
                    one.put("Normal Pos", s.get("Normal Pos"));
                    one.put("Iso Pos", s.get("Iso Pos"));
                    one.put("Fluid", s.get("Fluid"));
                    one.put("Size", s.get("Size"));
                    one.put("Rec ID", s.get("Rec ID"));
                    noMatch = false;
                    matched ++;
                }
            }
            if(one.get("ID")!=null) combined.add(one);
            if(noMatch && s.get("ID")!=null) {
                combined.add(s);
            }

        }
        System.out.println("combined.size() = " + combined.size());
        WriteExcel.writeCustom("MyVsOld.xlsx","match", combined);

        for(LinkedHashMap<String,String> s : allMy){
            boolean noMatch = true;
            for(LinkedHashMap<String,String> e : allOld){
                if(s.get("ID").equals(e.get("ID"))&&s.get("ID")!=null){
                    noMatch = false;
                }
            }
            if(noMatch && s.get("ID")!=null) {
                mismatch.add(s);
            }

        }
        System.out.println("mismatch.size() = " + mismatch.size());
        System.out.println("matched = " + matched);;
        WriteExcel.writeCustom("MyVsOld.xlsx","mismatch", mismatch);
        
    }
}
