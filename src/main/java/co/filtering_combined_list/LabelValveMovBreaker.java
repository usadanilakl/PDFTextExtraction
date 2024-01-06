package co.filtering_combined_list;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;
import co.TextSortingMethods;
import co.WriteExcel;

public class LabelValveMovBreaker {
    public static void main(String[] args) {
        ExcelUtil my = new ExcelUtil("Ready.xlsx", "All Together");
        List<LinkedHashMap<String, String>> allMy = my.getDataList();

        for (LinkedHashMap<String, String> s : allMy) {
            s.put("ID", TextSortingMethods.getLettersAndDigits(s.get("ID") + ""));
            if (s.get("ID").startsWith("00")) s.put("Unit", "BOP");
            else if (s.get("ID").startsWith("01")) s.put("Unit", "Unit 1");
            else if (s.get("ID").startsWith("02")) s.put("Unit", "Unit 2");
            else s.put("Unit", "no data");
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
            s.putIfAbsent("Duplicate", "no");
            if(s.get("Location").contains("BR") || s.get("Location").contains("TCP") || s.get("Location").toLowerCase().contains("cubicle")) s.put("T","Electr");
            if(s.get("ID").contains("-V")) s.put("T","V");
            if(s.get("ID").contains("MOV")) s.put("T","MOV");
            if(!s.get("ID").contains("-")) s.put("T","Mitsu");
            if(s.get("ID").contains("-V")) s.put("T","V");
            if(s.get("ID").contains("Brker")) s.put("T","HT");
        }

        System.out.println("allMy size: " + allMy.size());
        int matched = 0;

        List<LinkedHashMap<String, String>> noDashList = new ArrayList<>();
        List<LinkedHashMap<String, String>> duplicateList = new ArrayList<>();

        for (LinkedHashMap<String, String> s : allMy) {
            
                if (!s.get("ID").contains("-")) {
                    noDashList.add(s);

                
            }

        }
       // System.out.println("unique.size() = " + uniqueList.size());
        WriteExcel.writeCustom("unique.xlsx", "unique", allMy);


    }
}
