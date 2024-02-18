package co.htobjects_to_json;


import co.WriteExcel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class HtJsonToJava {
    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String path = "heat_trace_files/HT_Panels.json";
        String path2 = "heat_trace_files/ht.json";
        String path3 = "heat_trace_files/new.json";

        List<Panel> panels = new ArrayList<>();
        List<Single_POJO> lines = new ArrayList<>();
        Panel panel = new Panel();
        try {
            //panels = om.readValue(new File(path),List.class);
            panels = om.readValue(new File(path), new TypeReference<List<Panel>>() {});
            //lines = om.readValue(new File(path2), new TypeReference<List<Single_POJO>>() {});
            //panel = om.readValue(new File(path3), Panel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(panels.get(1).getBreakers().get(0));
        //System.out.println("lines.get(0) = " + lines.get(0));
        //System.out.println(panel.getBreakers().get(0));

        System.out.println(panels.get(0).getBreakers().get(1));

        List<LinkedHashMap<String,String>> htMap = new ArrayList<>();

        panels.forEach(p->{
            p.getBreakers().forEach(b->{
                LinkedHashMap<String,String> item = new LinkedHashMap<>();
                item.put("ID",p.getPanelNumber()+"-"+b.getBrNumber());
                item.put("location", p.getLocation() + "Br:"+b.getBrNumber());
                String description = "";
                for (Circuit c : b.getCircuits()) {
                    description+=c.getCircNumber()+"/";
                }
                item.put("description",description);
                htMap.add(item);
            });
        });

        WriteExcel.writeCustom("ht.xlsx","ht",htMap);
        System.out.println(htMap.size());
    }
}
