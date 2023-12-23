package co.collection_of_valve_lists;

import co.ExcelUtil;
import co.TextSortingMethods;
import co.WriteExcel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyListSplitByUnits {
    public static void main(String[] args) {
        ExcelUtil singleValve = new ExcelUtil("LOTO.xlsx", "Sheet4");
        List<LinkedHashMap<String, String>> valves = singleValve.getDataList();
        for(LinkedHashMap<String,String> s : valves){
            s.replace("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")));
        }

        List<LinkedHashMap<String,String>> unit1_unit2_bop = new ArrayList<>();

        for(LinkedHashMap<String,String> s : valves){
            if(s.get("ID").startsWith("01")||s.get("ID").startsWith("02")||s.get("ID").startsWith("00")){
                unit1_unit2_bop.add(s);
            }else{
                LinkedHashMap<String,String> item = new LinkedHashMap<>(Map.copyOf(s));
                item.put("ID", "01-"+item.get("ID"));
                unit1_unit2_bop.add(item);

                s.put("ID", "02-"+s.get("ID"));
                unit1_unit2_bop.add(s);
            }
        }



       WriteExcel.write("Sheet1",unit1_unit2_bop);


    }
}