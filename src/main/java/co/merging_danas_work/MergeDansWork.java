package co.merging_danas_work;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;


public class MergeDansWork {
    public static void main(String[] args) {
    try{
    //Get Danas File
    ExcelUtil dana = new ExcelUtil("dana.xlsx", "unique");
    List<LinkedHashMap<String, String>> allDana = dana.getDataList();
    ExcelUtil.fillEmptyCells(allDana);

    //Get current file
    ExcelUtil current = new ExcelUtil("current.xlsx", "unique");
    List<LinkedHashMap<String, String>> allCurrent = current.getDataList();
    ExcelUtil.fillEmptyCells(allCurrent);

    //Get panels from Danas table
    System.out.println(allDana.size());
    List<String> dPanels = new ArrayList<>();
    for(LinkedHashMap<String,String> e : allDana){
       // if(e.get("Location")!=null)
        if(e.get("Location").contains("-PPL-")||e.get("Location").contains("-SWB-")){
            dPanels.add(e.get("Location").substring(0,16));
            System.out.println(e.get("Location").substring(0,16));
        }
    }

    //Get panels from current table
    List<String> cPanels = new ArrayList<>();
    for(LinkedHashMap<String,String> e : allCurrent){
        if(e.get("Location").contains("-PPL-")||e.get("Location").contains("-SWB-")) cPanels.add(e.get("Locatio").substring(0,16));
    }

    //Compare panels and print differences
    for(String e : dPanels){
        if(!cPanels.contains(e)) System.out.println(e);
    }
    //Fix differences in current file

    //Get each panel from Danas file

    //Get each panel from current file

    //Compare breakers of panels using IDs

    // Show mismatch
}catch(Exception e){
    e.printStackTrace();
}
}
}
