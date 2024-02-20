package co.filling_in_info_for_loto_points;

import java.util.LinkedHashMap;
import java.util.List;

import co.ExcelUtil;
import co.WriteExcel;

public class FillExtraInfo {

    public static void main(String[] args) {
        ExcelUtil exel = new ExcelUtil("src/main/java/co/filling_in_info_for_loto_points/LOTO_ready.xlsx", "IsolationPoints");
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

        ExcelUtil exel2 = new ExcelUtil("src/main/java/co/filling_in_info_for_loto_points/panels.xlsx", "Sheet1");
        List<LinkedHashMap<String,String>> panels = exel2.getDataList();

        for(LinkedHashMap<String,String> s : panels){
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

        //crossmatch tagged items
        all.forEach(
                a->{
                    if(!(a.get("Tagged").equals("NO")&&a.get("Tagged").equals("NO DATA"))){
                        if(a.get("ID").startsWith("01")){
                            all.stream().filter(i->("02"+a.get("ID").substring(2)).equals(i.get("ID"))).forEach(m->m.put("Tagged",a.get("Tagged")));
                        }
                        if(a.get("ID").startsWith("02")){
                            all.stream().filter(i->("01"+a.get("ID").substring(2)).equals(i.get("ID"))).forEach(m->m.put("Tagged",a.get("Tagged")));
                        }
                    }
                }
        );
        //fill in the system
        all.forEach(
                a->{
                    if(a.get("Standard").contains("/")) a.put("System",a.get("Standard").substring(0,a.get("Standard").indexOf("/")));
                    else if(a.get("Standard").contains(" ")) a.put("System",a.get("Standard").substring(0,a.get("Standard").indexOf(" ")));
                    else a.put("System",a.get("Standard"));
                }
        );

        //fill in the type
        all.forEach(
                a->{
                    if(a.get("Description").contains("ISO")) a.put("Type","ISO");
                    else if(a.get("Description").contains("DRAIN")) a.put("Type","DRAIN");
                    else if(a.get("Description").contains("VENT")) a.put("Type","VENT");

                    if(a.get("ID").contains("-MOV-")) a.put("Type","MOV");
                    if(a.get("ID").contains("-YV-")) a.put("Type","AOV");

                }
        );

        panels.forEach(
            p->{
                LinkedHashMap<String,String> c = new LinkedHashMap<>(p);
                if(!p.get("Num").equals("no data")){
                all.stream().filter(a->a.get("Num").equals(p.get("Num"))).forEach(a->{
                    a.put("ID",p.get("ID"));
                    a.put("Location",p.get("Location"));
                    a.put("Description",p.get("Description"));
                    a.put("T",p.get("T"));
                });
            }else{
                c.put("Num","New");
                all.add(c);
            }
        });

        WriteExcel.writeCustom("src/main/java/co/filling_in_info_for_loto_points/LOTO_ready.xlsx","new",all);
    }



}
