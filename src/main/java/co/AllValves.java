package co;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AllValves{
    public static void main(String[] args) {
        ExcelUtil e = new ExcelUtil("C:/Users/usada/IdeaProjects/PDFTextExtraction/LOTO.xlsx", "Sheet1");
       List<Map<String,String>> all = e.getDataList();

         List<Map<String,String>> newAll = new ArrayList<>();
//        System.out.println("all.size() = " + all.size());
//        for(Map<String,String> a : all){
//            System.out.println(a.get("ID").contains("/"));
//        }

       for(Map<String,String> every : all){
        if(every.get("ID")!=null &&every.get("ID").contains("/")){
            String[] id = every.get("ID").replace(" ","").split("/");
            for(int i = 1; i<id.length; i++){
                Map<String,String> splitItem = new LinkedHashMap<>(Map.copyOf(every));
                splitItem.put("ID", id[0].substring(0,3)+id[i]);
                newAll.add(splitItem);
            }
        }else{
               newAll.add(every);
            }
       }
        System.out.println("size: "+newAll.size());
       for(Map<String,String> m : newAll){

        System.out.println(m.get("ID"));
       }
    }
}