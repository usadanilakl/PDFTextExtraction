package co.filter_duplicates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import co.ExcelUtil;

public class Filter {
    public static void main(String[] args) {
        ExcelUtil exel = new ExcelUtil("src\\main\\java\\co\\filter_duplicates\\LOTO_ready.xlsx", "ISOLATION POINTS");
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

        List<LinkedHashMap<String,String>> duplicates = new ArrayList<>();
        Set<String> locations = new HashSet<>();
        all.forEach(a->{
            if(!a.get("Standard").equals("NO DATA") && !a.get("Location").contains("-LV")) locations.add(a.get("Location"));
           List<LinkedHashMap<String,String>> l = all.stream().filter(f->f.get("ID").equals(a.get("ID"))).collect(Collectors.toList());

           if(l.size()>1){
           l.forEach(e->{
            if(duplicates.stream().filter(d->d.get("num2").equals(e.get("num2"))).findAny().isEmpty()) duplicates.add(e);
           });
        }
        });

        locations.forEach(e->System.out.println(e));

       // WriteExcel.writeCustom("src/main/java/co/filter_duplicates/LOTO_ready.xlsx","Duplicates",duplicates);

    }
}
