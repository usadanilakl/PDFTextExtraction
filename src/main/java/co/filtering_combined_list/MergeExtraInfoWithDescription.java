package co.filtering_combined_list;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;
import co.WriteExcel;

public class MergeExtraInfoWithDescription {
    public static void main(String[] args) {
        ExcelUtil my = new ExcelUtil("Ready.xlsx", "unique");
        List<LinkedHashMap<String, String>> allMy = my.getDataList();

        for(LinkedHashMap<String,String> s : allMy){
            s.putIfAbsent("T", "no data");
            s.putIfAbsent("Unit", "no data");
            s.putIfAbsent("Location", "no data");
            s.putIfAbsent("Normal Pos", "no data");
            s.putIfAbsent("Description", "no data");
            s.putIfAbsent("Equipment", "no data");
            s.putIfAbsent("Extra Info", "no data");
            s.putIfAbsent("Type", "no data");
            s.putIfAbsent("System", "no data");
            s.putIfAbsent("P&ID", "no data");
            s.putIfAbsent("Iso Pos", "no data");
            s.putIfAbsent("Fluid", "no data");
            s.putIfAbsent("Size", "no data");
            s.putIfAbsent("Equip", "no data");
            s.putIfAbsent("Rec ID", "no data");
        }

        System.out.println("allMy size: " + allMy.size());

        List<LinkedHashMap<String,String>> uniqueList = new ArrayList<>();
        
        for(LinkedHashMap<String,String> s : allMy){
                
                if(s.get("Description").equals("no data") && !s.get("Extra Info").equals("no data")){
                
                    s.put("Description", s.get("Extra Info"));
                }
            


            }
            System.out.println("After: " +allMy.size());
        WriteExcel.writeCustom("unique.xlsx","unique", allMy);

    }
}
