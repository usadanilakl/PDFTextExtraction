package co;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AllValves{
    public static void main(String[] args) {
        ExcelUtil e = new ExcelUtil("LOTO.xlsx", "Sheet1");
        List<LinkedHashMap<String,String>> all = e.getDataList();
        List<LinkedHashMap<String,String>> newAll = new ArrayList<>();


       for(LinkedHashMap<String,String> every : all){
        if(every.get("ID").contains("/")){
            String[] id = every.get("ID").replace(" ","").split("/");
            every.replace("ID", id[0]);
            newAll.add(every);
            for(int i = 1; i<id.length; i++){
                LinkedHashMap<String,String> splitItem = new LinkedHashMap<>(Map.copyOf(every));
                splitItem.replace("ID", TextSortingMethods.getOnlyLetters(id[0])+id[i]);
                newAll.add(splitItem);
            }
            
        }else{
               newAll.add(every);
            }
       }
        System.out.println("size: "+newAll.size());
       for(LinkedHashMap<String,String> m : newAll){
        if(m.get("ID")!=null)
        m.put("ID",m.get("ID").replace(" ",""));

        
       }

       //WriteExcel.write("Sheet4",newAll);


    }
}