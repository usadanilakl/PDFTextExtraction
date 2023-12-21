package co;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AddPidsToValveList {
    public static void main(String[] args) {

        // get valves from excel:
        ExcelUtil singleValve = new ExcelUtil("LOTO.xlsx", "Sheet4");
        List<LinkedHashMap<String, String>> valves = singleValve.getDataList();
        for(LinkedHashMap<String,String> s : valves){
            s.replace("ID",TextSortingMethods.getLettersAndDigits(s.get("ID")));
        }
        System.out.println(valves.size());

        // get valves and pids from original content
        List<String[]> pids = new ArrayList<>();
        for (Map.Entry<String, String> e : OriginalContentMap.originalContent.entrySet()) {
            String pidNum = e.getKey();
            for (String vlv : GetArray.getValves(e.getValue())) {
                String[] listOfValves = { pidNum, vlv };
                pids.add(listOfValves);
            }

        }

        // combine valves and pids arrays:
        List<LinkedHashMap<String, String>> newValveList = new ArrayList<>();
        for (String[] e : pids) {
            boolean contains = false;
            LinkedHashMap<String, String> item = new LinkedHashMap<>();
            for (LinkedHashMap<String, String> v : valves) {
                if (e[1].trim().equals(v.get("ID").replace(" ","").trim()) || e[1].trim().substring(3).equals(v.get("ID").replace(" ","").trim())) {
                    item = new LinkedHashMap<>(Map.copyOf(v));

                    contains = true;
                    break;
                }

            }
            if (contains) {
                item.replace("P&ID", e[0]);
                item.replace("ID", e[1]);
                newValveList.add(item);
            } else {

                newValveList.add(new LinkedHashMap<>(Map.of("ID", e[1], "Description", "no data", "Location", "no data",
                        "Equipment", "no data", "Type", "no data", "System", "no data", "P&ID", e[0],
                        "Normal Pos", "no data", "Iso Pos", "no data")));
            }

        }

        for(LinkedHashMap<String,String> v : valves){
            boolean contains = false;
            for(String[] p : pids){
                if(p[1].trim().contains(v.get("ID").replace(" ","").trim())){
                    contains = true;
                    break;
                }
            }
            if(!contains) newValveList.add(new LinkedHashMap(Map.copyOf(v)));
        }

        System.out.println(newValveList.size());
        WriteExcel.write("Sheet6", newValveList);

    }

}
