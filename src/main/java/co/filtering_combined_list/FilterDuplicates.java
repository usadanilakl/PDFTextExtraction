package co.filtering_combined_list;

import co.ExcelUtil;
import co.TextSortingMethods;
import co.WriteExcel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class FilterDuplicates {
    public static void main(String[] args) {
        ExcelUtil my = new ExcelUtil("Ready.xlsx", "All Together");
        List<LinkedHashMap<String, String>> allMy = my.getDataList();

        for(LinkedHashMap<String,String> s : allMy){
            s.put("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")+""));
            if(s.get("ID").startsWith("00")) s.put("Unit","BOP");
            else if(s.get("ID").startsWith("01")) s.put("Unit","Unit 1");
            else if(s.get("ID").startsWith("02"))s.put("Unit","Unit 2");
            else s.put("Unit","no data");
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
        int matched = 0;

        List<LinkedHashMap<String,String>> uniqueList = new ArrayList<>();
        List<LinkedHashMap<String,String>> duplicateList = new ArrayList<>();

        for(LinkedHashMap<String,String> s : allMy){
            LinkedHashMap<String,String> one = s;
            LinkedHashMap<String,String> duplicate = new LinkedHashMap<>();
            boolean noMatch = true;
            for(LinkedHashMap<String,String> e : uniqueList){
                duplicate = e;
                if(s.get("ID").equals(e.get("ID"))&&s.get("ID")!=null){
                    duplicateList.add(s);
                    duplicateList.add(e);
                    //System.out.println("Success");
                    //one.put("ID", s.get("ID"));
                    if(!one.get("Description").equals("no data") && e.get("Description").equals("no data"))e.put("Description", e.get("Description"));
                    if(!one.get("Location").equals("no data") && e.get("Location").equals("no data"))e.put("Location", e.get("Location"));
                    if(!one.get("Equipment").equals("no data") && e.get("Equipment").equals("no data"))e.put("Equipment", e.get("Equipment"));
                    if(!one.get("Extra Info").equals("no data") && e.get("Extra Info").equals("no data"))e.put("Extra Info", e.get("Extra Info"));
                    if(!one.get("Type").equals("no data") && e.get("Type").equals("no data"))e.put("Type", e.get("Type"));
                    if(!one.get("System").equals("no data") && e.get("System").equals("no data"))e.put("System", e.get("System"));
                    //one.put("SystemM", e.get("System"));
                    if(!one.get("P&ID").equals("no data") && e.get("P&ID").equals("no data"))e.put("P&ID", e.get("P&ID"));
                    if(!one.get("Normal Pos").equals("no data") && e.get("Normal Pos").equals("no data"))e.put("Normal Pos", e.get("Normal Pos"));
                    if(!one.get("Iso Pos").equals("no data") && e.get("Iso Pos").equals("no data"))e.put("Iso Pos", e.get("Iso Pos"));
                    if(!one.get("Fluid").equals("no data") && e.get("Fluid").equals("no data"))e.put("Fluid", e.get("Fluid"));
                    if(!one.get("Size").equals("no data") && e.get("Size").equals("no data"))e.put("Size", e.get("Size"));
                    //if(one.get("Description")==null && e.get("Description")!=null)one.put("Rec ID", s.get("Rec ID"));
                    noMatch = false;
                    matched ++;

                }



            }

            if(noMatch)uniqueList.add(one);
//            else{
//                duplicateList.add(s);
//                duplicateList.add(duplicate);
//            }
        }
        System.out.println("combined.size() = " + uniqueList.size());
        WriteExcel.writeCustom("unique.xlsx","unique", uniqueList);

        
        System.out.println("mismatch.size() = " + duplicateList.size());
        System.out.println("matched = " + matched);;
        WriteExcel.writeCustom("unique.xlsx","duplicates", duplicateList);

    }
}
