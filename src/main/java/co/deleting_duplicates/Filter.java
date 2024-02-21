package co.deleting_duplicates;

import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;
import co.WriteExcel;

public class Filter {
    public static void main(String[] args) {
        ExcelUtil exel2 = new ExcelUtil("src\\main\\java\\co\\deleting_duplicates\\LOTO_ready.xlsx", "Duplicates");
        List<LinkedHashMap<String,String>> dup = exel2.getDataList();

        for(LinkedHashMap<String,String> s : dup){
            s.putIfAbsent("T", "no data");
            s.putIfAbsent("Unit", "no data");
            s.putIfAbsent("Standard", "no data");
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
            s.putIfAbsent("Num", "no data");
            s.putIfAbsent("ID", "no data");


        }

        ExcelUtil exel = new ExcelUtil("src\\main\\java\\co\\deleting_duplicates\\LOTO_ready.xlsx", "ISOLATION POINTS");
        List<LinkedHashMap<String,String>> all = exel.getDataList();

        for(LinkedHashMap<String,String> s : all){
            s.putIfAbsent("T", "no data");
            s.putIfAbsent("Unit", "no data");
            s.putIfAbsent("Standard", "no data");
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
            s.putIfAbsent("Num", "no data");
            s.putIfAbsent("ID", "no data");


        }

        System.out.println("before: "+all.size());


        dup.forEach(d->{
            if(d.get("Tagged").equals("delete")){
                all.remove(all.stream().filter(a->a.get("num2").equals(d.get("num2"))).findFirst().get());
            }
        });

        System.out.println("after: "+all.size());
        WriteExcel.writeCustom("src/main/java/co/deleting_duplicates/LOTO_ready.xlsx","new",all);

    }


}
