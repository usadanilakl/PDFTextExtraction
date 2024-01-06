package co.filtering_combined_list;

import co.ExcelUtil;
import co.TextSortingMethods;
import co.WriteExcel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MarkDuplicates {
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
        }

        System.out.println("allMy size: " + allMy.size());
        int matched = 0;

        List<LinkedHashMap<String, String>> uniqueList = new ArrayList<>();
        List<LinkedHashMap<String, String>> duplicateList = new ArrayList<>();

        for (LinkedHashMap<String, String> s : allMy) {
            for (LinkedHashMap<String, String> e : uniqueList) {
                if (s.get("ID").equals(e.get("ID")) && s.get("ID") != null) {
                    s.put("Duplicate", "yes");
                    e.put("Duplicate", "yes");
                    matched++;

                }
            }

            uniqueList.add(s);

        }
        System.out.println("unique.size() = " + uniqueList.size());
        WriteExcel.writeCustom("unique.xlsx", "unique", uniqueList);


    }
}
