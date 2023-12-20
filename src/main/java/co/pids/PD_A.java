package co.pids;
import java.util.Arrays;
import java.util.List;

import co.GetArray;

public class PD_A {
    public static String pid = "PD-0A";
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
