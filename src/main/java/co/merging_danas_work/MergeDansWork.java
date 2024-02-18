package co.merging_danas_work;

import java.util.*;

import co.ExcelUtil;
import co.WriteExcel;


public class MergeDansWork {
    public static void main(String[] args) {

    //Get Danas File
    ExcelUtil dana = new ExcelUtil("dana.xlsx", "unique");
    List<LinkedHashMap<String, String>> allDana = dana.getDataList();
    //ExcelUtil.fillEmptyCells(allDana);
        System.out.println("getting rid of null: ");
    for(LinkedHashMap<String,String> s : allDana){
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
            s.putIfAbsent("OTHER PID", "no data");
            s.putIfAbsent("Iso Pos", "no data");
            s.putIfAbsent("Fluid", "no data");
            s.putIfAbsent("Size", "no data");
            s.putIfAbsent("Equip", "no data");
            s.putIfAbsent("Rec ID", "no data");
        s.putIfAbsent("Tagged", "no data");
        s.putIfAbsent("Duplicate", "no data");
        s.putIfAbsent("Dana", "no data");

    }

        //System.out.println(allDana.get(0).get("Location"));


    //Get current file
    ExcelUtil current = new ExcelUtil("current.xlsx", "unique");
    List<LinkedHashMap<String, String>> allCurrent = current.getDataList();
    ExcelUtil.fillEmptyCells(allCurrent);
        System.out.println("getting rid of null");
    for(LinkedHashMap<String,String> s : allCurrent){
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
        s.putIfAbsent("OTHER PID", "no data");
        s.putIfAbsent("Iso Pos", "no data");
        s.putIfAbsent("Fluid", "no data");
        s.putIfAbsent("Size", "no data");
        s.putIfAbsent("Equip", "no data");
        s.putIfAbsent("Rec ID", "no data");
        s.putIfAbsent("Tagged", "no data");
        s.putIfAbsent("Duplicate", "no data");
        s.putIfAbsent("Dana", "no data");
    }
        //System.out.println(allCurrent.get(0).get("Location"));

    //Get panels from Danas table
    //System.out.println(allDana.size());
    List<LinkedHashMap<String,String>> dPanels = new ArrayList<>();
    for(LinkedHashMap<String,String> e : allDana){
       // if(e.get("Location")!=null)
        //System.out.println(e.get("Location"));
        if(e.get("Location").contains("-PPL-")||e.get("Location").contains("-SWB-")){
            dPanels.add(e);
            //System.out.println(e.get("Location").substring(0,16));
        }
    }

        //System.out.println(dPanels);

    //Get panels from current table
    List<LinkedHashMap<String,String>> cPanels = new ArrayList<>();
    for(LinkedHashMap<String,String> e : allCurrent){
        if(e.get("Location").contains("-PPL-")||e.get("Location").contains("-SWB-")){
            cPanels.add(e);
           //System.out.println(e.get("Location").substring(0,16));
        }
    }

    int mismatch = 0;
    int changed = 0;
    List<LinkedHashMap<String,String>> mismatchedBrs = new ArrayList<>();
    //Compare panels and print differences
    for(LinkedHashMap<String,String> e : dPanels){
        boolean contains = false;
        //boolean locAndDescr = !(e.get("Location").equals(s.get("Location")) && e.get("Description").equals(s.get("Description"))
        for(LinkedHashMap<String,String> s : allCurrent){
            if(e.get("ID").equals(s.get("ID")) && (s.get("Location").contains("-PPL-")||s.get("Location").contains("-SWB-"))){
                contains = true;
                changed++;
                s.put("Location",e.get("Location"));
                s.put("Description",e.get("Description"));
                s.put("Dana",e.get("Dana"));
            }
        }
        if(!contains){
            mismatch++;
            mismatchedBrs.add(e);
        }
    }

        for(LinkedHashMap<String,String> e : dPanels){
            int unit = 0;
            int brkr = 0;
            if(e.get("Location").contains("01-")) unit = e.get("Location").indexOf("01-");
            if(e.get("Location").contains("02-")) unit = e.get("Location").indexOf("02-");
            if(e.get("Location").contains("00-")) unit = e.get("Location").indexOf("00-");
            if(e.get("Location").toLowerCase().contains("br")) brkr = e.get("Location").indexOf("br");
            String panel = "no data";
            String br = "";
            if(e.get("Location").toLowerCase().contains("br")){
                panel = e.get("Location").toLowerCase().substring(unit, e.get("Location").toLowerCase().indexOf("br")).replace(",","");
                String breaker = e.get("Location").toLowerCase().substring(e.get("Location").toLowerCase().indexOf("br"));

                for(Character i : breaker.toCharArray()){
                    if(!Character.isLetter(i)) br+=i;
                }
            }else br = "no data";


            System.out.println("{id:'"+e.get("ID")+"',panel:'"+panel+"',br:'"+br+"',description:'"+e.get("Description")+"',location:'"+e.get("Location")+"'},");
        }
//        System.out.println(dPanels.size() +"panelSize");
//        System.out.println(mismatch);
//        System.out.println(changed);


        //replace items with matching ID and separate mismatches
//        WriteExcel.writeCustom("unique.xlsx","duplicates", mismatchedBrs);
//        WriteExcel.writeCustom("unique.xlsx","unique", allCurrent);
}
}
