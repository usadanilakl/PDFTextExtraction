package com.pids;
import java.util.Arrays;
import java.util.List;

import com.GetArray;

public class PD_035A {
    public static String pid = "PD-035A";
    public static String original = "";
    public static List<String> equipment;

    static{
        equipment = Arrays.asList(

        
        );
    }
    public static void main(String[] args) {
        GetArray.getAllEquipment(original,pid);
    }
}
