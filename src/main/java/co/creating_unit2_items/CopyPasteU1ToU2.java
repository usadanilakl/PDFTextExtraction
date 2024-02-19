package co.creating_unit2_items;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import co.ExcelUtil;
import co.WriteExcel;

public class CopyPasteU1ToU2 {
    public static void main(String[] args) {
        
        //get unit 1 items from excel
        ExcelUtil u1Excel = new ExcelUtil("creating_u2_standards/u1.xlsx", "u1");
        List<LinkedHashMap<String,String>> u1 = u1Excel.getDataList();
        for(LinkedHashMap<String,String> s : u1){
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
        s.putIfAbsent("Num", "no data");

    }
    //System.out.println("U1 items" + u1.size());

        //get all items from excel
        ExcelUtil allExcel = new ExcelUtil("creating_u2_standards/LOTO.xlsx", "unique");
        List<LinkedHashMap<String,String>> all = allExcel.getDataList();
        for(LinkedHashMap<String,String> s : all){
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
        s.putIfAbsent("Num", "no data");
        s.putIfAbsent("ID", "no data");

    }

    System.out.println("U1 items" + u1.size());
    System.out.println("all items" + all.size());

    //System.out.println(all.get(0));
        
        //create standards for u2: update match or create new
        // List<LinkedHashMap<String,String>> res = new ArrayList<>();
        // for(LinkedHashMap<String,String> e : all){
        //         LinkedHashMap<String,String> a = new LinkedHashMap<>(e);
                // for(LinkedHashMap<String,String> i : u1){  
                //         if (a.get("ID").trim().toUpperCase().equals("02"+i.get("ID").toUpperCase().trim().substring(2))){
                //             a.put("Description", i.get("Description"));
                //             a.put("Location", i.get("Location"));
                //             a.put("Normal Pos", i.get("Normal Pos"));
                //             a.put("Iso Pos", i.get("Iso Pos"));
                //             a.put("Unit", "Unit 2");
                //         }else{
                //             LinkedHashMap<String,String> n = new LinkedHashMap<>(i);
                //             n.put("ID", "02"+n.get("ID").toUpperCase().trim().substring(2));
                //             n.put("Unit", "Unit 2 new");
                //             res.add(n);
                //         }
                //     }
            //     res.add(a);
            // }
        // System.out.println("res size: " + res.size());
    
    for(LinkedHashMap<String,String> e : u1){
        Optional<LinkedHashMap<String,String>> match = all.stream().filter(a->a.get("ID").trim().toUpperCase().equals("02"+e.get("ID").trim().toUpperCase().substring(2))).findFirst();
        if(match.isPresent()){
            LinkedHashMap<String,String> a = all.get(all.indexOf(match.get()));
            a.put("ID","02"+e.get("ID").trim().toUpperCase().substring(2));
            a.put("Description", e.get("Description").trim().toUpperCase());
            a.put("Standard", e.get("Standard").trim().toUpperCase());
            if(!e.get("Unit").equals("EXCLUDE")) a.put("Location", e.get("Location").trim().toUpperCase());
            a.put("Normal Pos", e.get("Normal Pos").trim().toUpperCase());
            a.put("Iso Pos", e.get("Iso Pos").trim().toUpperCase());
            a.put("Unit", "Unit 2 updated");
            //if()a.put("Tagged", e.get("Tagged"));
        }else{
            LinkedHashMap<String,String> n = new LinkedHashMap<>(e);
            n.put("ID", "02"+n.get("ID").toUpperCase().trim().substring(2));
            n.put("Unit", "Unit 2 new");
            all.add(n);
        }
    }

    Set<String> standards = new HashSet<>();
    Set<String> locations = new HashSet<>();

    all.forEach(e->{
        standards.add(e.get("Standard"));
        if(!(e.get("Location").contains("SWG") || e.get("Location").contains("LVD") ||e.get("Location").contains("LVB") || e.get("Location").contains("MCC")))locations.add(e.get("Location"));
        e.entrySet().forEach((set)->{
            e.put(set.getKey(),set.getValue().toUpperCase().trim());
        });
    });

    System.out.println("Standards:");
    //standards.forEach(e->System.out.println(e));

    System.out.println("locations:");
   // locations.forEach(e->System.out.println(e));

    System.out.println(all.size());
    
    WriteExcel.writeCustom("creating_u2_standards/LOTO_ready.xlsx","IsolationPoints",all);

    }
}
