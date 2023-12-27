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

        // ExcelUtil ready = new ExcelUtil("LOTOJ.xlsx", "Ready");
        // List<LinkedHashMap<String, String>> allReady = ready.getDataList();

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

        
        for(LinkedHashMap<String,String> s : allOld){
            LinkedHashMap<String,String> one = new LinkedHashMap<>();
            boolean noMatch = true;
            for(LinkedHashMap<String,String> e : allVend){
                if(s.get("ID").contains(e.get("ID"))&&!s.get("ID").equals(null)){
                    //System.out.println("Success");
                    one.put("ID", e.get("ID"));
                    one.put("Description", e.get("Description"));
                    one.put("Location", e.get("Location"));
                    one.put("Equipment", e.get("Equipment"));
                    one.put("Extra Info", s.get("Extra Info"));
                    one.put("Type", s.get("Type"));
                    one.put("System", s.get("System"));
                    //one.put("SystemM", s.get("System"));
                    one.put("P&ID", s.get("P&ID"));
                    one.put("Normal Pos", e.get("Normal Pos"));
                    one.put("Iso Pos", e.get("Iso Pos"));
                    one.put("Fluid", s.get("Fluid"));
                    one.put("Size", s.get("Size"));
                    one.put("Rec ID", s.get("Rec ID"));
                    noMatch = false;
                }
            }
            if(one.get("ID")!=null) combined.add(one);
            if(noMatch && s.get("ID")!=null) {
                mismatch.add(s);
                combined.add(s);
            }

        }
        
        //     for(LinkedHashMap<String,String> s : allMy){
        //     LinkedHashMap<String,String> one = new LinkedHashMap<>();
        //     boolean noMatch = true;
        //     for(LinkedHashMap<String,String> e : allOld){
        //         if(s.get("ID").contains(e.get("ID"))&&!s.get("ID").equals(null)){
        //             System.out.println("Success");
        //             one.put("ID", s.get("ID"));
        //             one.put("DescriptionV", s.get("Description"));
        //             one.put("LocationV", s.get("Location"));
        //             one.put("EquipmentV", s.get("Equipment"));

        //             one.put("ID", e.get("ID"));
        //             one.put("Description", e.get("Description"));
        //             one.put("Location", e.get("Location"));
        //             one.put("Equipment", e.get("Equipment"));

        //             // one.put("PIDV", s.get("P&ID"));
        //              one.put("PID", e.get("P&ID"));

        //             noMatch = false;
        //         }
        //     }
        //     if(one.get("ID")!=null) combined.add(one);
        //     if(noMatch && s.get("ID")!=null) mismatch.add(s);

        // }
        System.out.println(combined.size());
        //System.out.println(combined);
        //WriteExcel.writeCustom("match", combined);
        WriteExcel.writeCustom("mismatch", mismatch);
        
    }
}
