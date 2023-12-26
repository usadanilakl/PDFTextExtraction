package co.Electrical;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;

public class GetUniquePanels{
    public static void main(String[] args) {
        ExcelUtil panels = new ExcelUtil("Electrical Table.xlsx", "Sheet2");
        List<LinkedHashMap<String, String>> allPanels = panels.getDataList();
        List<String> uniquePanels = new ArrayList<>();
        List<String> uniqueLocations = new ArrayList<>();
        for(LinkedHashMap<String,String> s : allPanels){
            if(!uniquePanels.contains(s.get("Bus"))){
                uniquePanels.add(s.get("Bus"));
                uniqueLocations.add(s.get("Breaker location"));
            }
        }

        for(String s : uniqueLocations){
            System.out.println(s);
        }
    }

}