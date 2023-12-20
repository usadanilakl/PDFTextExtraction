package com;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AllValves{
    public static void main(String[] args) {
        ExcelUtil e = new ExcelUtil("C:\\Users\\usada\\my_projects\\PDFTextExtraction\\LOTO.xlsx", "Sheet1");
       List<Map<String,String>> all = e.getDataList();

       List<Map<String,String>> newAll = new ArrayList<>();

       for(Map<String,String> every : all){
        if(every.get("ID").contains("/")){
            String[] id = every.get("ID").replace(" ","").split("/");
            for(String str : id){
                Map<String,String> splitItem = new LinkedHashMap<>(Map.copyOf(every));
                splitItem.put("ID", id[0].substring(0,4)+str);
                newAll.add(splitItem);
            }
        }else{
               newAll.add(every); 
            }
       }
       for(Map<String,String> m : newAll){
        System.out.println(m);
       }
    }
}