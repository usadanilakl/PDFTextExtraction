package co;
public class GetArray {
    public static void getAllEquipment(String original, String pid){
        original = threeLetterEquipment3LetterType1(original, pid);
        original = threeLetterEquipment2LetterType1(original, pid);
        original = threeLetterEquipment3LetterType2(original, pid);
        original = threeLetterEquipment2LetterType2(original, pid);
        original = threeLetterEquipment3LetterType3(original, pid);
        original = threeLetterEquipment2LetterTypeABC1(original, pid);
        original = threeLetterEquipment3LetterTypeABC1(original, pid);
        original = threeLetterEquipment2LetterTypeABC2(original, pid);
        original = threeLetterEquipment3LetterTypeABC2(original, pid);
        original = fourLetterEquipment(original, pid);
        original = pipe1(original, pid);
        original = pipe2(original, pid);
        original = pipe3(original, pid);
        original = pipe4(original, pid);
        original = equipment(original,pid);
        System.out.println("=================================================================");
        original = connections(original,pid);
        System.out.println("=================================================================");
        System.out.println("original = " + original);
    }
    public static String threeLetterEquipment3LetterType1(String original, String pid){
       int len = 15;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(0,3);
            String nubmers = sub.substring(3,6);
            String unit01 = sub.substring(7,12);
            String type = sub.substring(12);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(6));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(6)==' ' && allLetters(type)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                                "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment2LetterType1(String original, String pid){
        int len = 14;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(0,3);
            String nubmers = sub.substring(3,6);
            String unit01 = sub.substring(7,12);
            String type = sub.substring(12);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(6));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(6)==' ' && allLetters(type)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                                "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment3LetterType2(String original, String pid){
        int len = 15;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(9,12);
            String nubmers = sub.substring(12);
            String unit01 = sub.substring(0,5);
            String type = sub.substring(5,8);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(8));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(8)==' ' && allLetters(type)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                                "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment3LetterType3(String original, String pid){
        int len = 14;
        String unit = "01-";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(7,10);
            String nubmers = sub.substring(10,13);
            String unit01 = sub.substring(0,3);
            String type = sub.substring(3,6);
            char dash1 = sub.charAt(6);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(8));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && dash1 =='-' && allLetters(type)){
                System.out.println(
                        "\""+
                                sub.trim()+
                                "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment2LetterType2(String original, String pid){
        int len = 14;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(8,11);
            String nubmers = sub.substring(11);
            String unit01 = sub.substring(0,5);
            String type = sub.substring(5,7);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(8));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(7)==' ' && allLetters(type)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                               "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment3LetterTypeABC1(String original, String pid){
        int len = 16;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(0,3);
            String nubmers = sub.substring(3,6);
            String unit01 = sub.substring(8,13);
            String type = sub.substring(13);
            String lastLetter = sub.substring(6,7);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(6));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(7)==' ' && allLetters(type) && allLetters(lastLetter)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                                lastLetter+
                                "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment2LetterTypeABC1(String original, String pid){
        int len = 15;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(0,3);
            String nubmers = sub.substring(3,6);
            String unit01 = sub.substring(8,13);
            String type = sub.substring(13);
            String lastLetter = sub.substring(6,7);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(6));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(7)==' ' && allLetters(type) && allLetters(lastLetter)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                                lastLetter+
                                "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment3LetterTypeABC2(String original, String pid){
        int len = 16;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(9,12);
            String nubmers = sub.substring(12,15);
            String unit01 = sub.substring(0,5);
            String type = sub.substring(5,8);
            String lastLetter = sub.substring(15);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(8));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(8)==' ' && allLetters(type) && allLetters(lastLetter)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                                lastLetter+
                                "\","
                );
                original = original.replace(sub,"");

            }
        }
        return original;
    }
    public static String threeLetterEquipment2LetterTypeABC2(String original, String pid){
        int len = 15;
        String unit = "01 - ";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(8,11);
            String nubmers = sub.substring(11,14);
            String unit01 = sub.substring(0,5);
            String type = sub.substring(5,7);
            String lastLetter = sub.substring(14);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(8));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit) && sub.charAt(7)==' ' && allLetters(type) && allLetters(lastLetter)){
                System.out.println(
                        "\""+
                                unit01.replaceAll(" ","")+
                                type+
                                "-"+
                                letters+nubmers+
                                lastLetter+
                                "\","
                );
                original = original.replace(sub,"");
            }
        }
        return original;
    }
    public static String fourLetterEquipment(String original, String pid){
        int len = 11;
        String unit = "01-";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
            String letters = sub.substring(3,7);
            String nubmers = sub.substring(7,10);
            String unit01 = sub.substring(0,3);
            String lastLetter = sub.substring(10);
//            System.out.println("letters = " + letters);
//            System.out.println("nubmers = " + nubmers);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(6));
            if(allLetters(letters) && allNumbers(nubmers) && unit01.equals(unit)){
                System.out.println(
                                "\""+
                                sub.trim()+
                                "\","
                );
                original = original.replace(sub.trim(),"");
            }
        }
        return original;
    }
    public static String pipe4(String original, String pid){
        int len = "01-0.75\"-CND1050-1BAA2A-1.0 \"MOH".length();
        String unit = "01-";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);

            if(sub.startsWith(unit) && (sub.endsWith("\"MOH")||sub.endsWith("\"EOH") || sub.endsWith("\"MOC") || sub.endsWith("\"EOC"))){
                System.out.println(
                        "\""+
                                sub+
                                "\","
                );
                original = original.replace(sub,"");
            }
        }
        return original;
    }
    public static String pipe3(String original, String pid){
        int len = "01-2.5\"-CND1050-1BAA2A-1.0 \"MOH".length();
        String unit = "01-";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);

            if(sub.startsWith(unit) && (sub.endsWith("\"MOH")||sub.endsWith("\"EOH") || sub.endsWith("\"MOC") || sub.endsWith("\"EOC"))){
                System.out.println(
                        "\""+
                                sub+
                                "\","
                );
                original = original.replace(sub,"");
            }
        }
        return original;
    }
    public static String pipe2(String original, String pid){
        int len = "01-24\"-CND1050-1BAA2A-1.0 \"MOH".length();
        String unit = "01-";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);

            if(sub.startsWith(unit) && (sub.endsWith("\"MOH")||sub.endsWith("\"EOH") || sub.endsWith("\"MOC") || sub.endsWith("\"EOC"))){
                System.out.println(
                        "\""+
                                sub+
                                "\","
                );
                original = original.replace(sub,"");
            }
        }
        return original;
    }
    public static String pipe1(String original, String pid){
        int len = "01-2\"-CND1050-1BAA2A-1.0 \"MOH".length();
        String unit = "01-";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);

            if(sub.startsWith(unit) && (sub.endsWith("\"MOH")||sub.endsWith("\"EOH") || sub.endsWith("\"MOC") || sub.endsWith("\"EOC"))){
                System.out.println(
                        "\""+
                                sub+
                                "\","
                );
                original = original.replace(sub,"");
            }
        }
        return original;
    }
    public static String equipment(String original, String pid){
        int len = "01-CND-HTR-869".length();
        String unit = "01-";
        for(int i = 0; i<original.length()-len; i++){
            String sub = original.substring(i,len+i);
        String letters = sub.substring(3,6);
        String lett = sub.substring(7,10);
        String unit01 = sub.substring(0,3);
        char dash1 = sub.charAt(6),dash2 = sub.charAt(10);

//            System.out.println("letters = " + letters);
//            System.out.println("lett = " + lett);
//            System.out.println("unit01 = " + unit01);
//            System.out.println("type = " + type);
//            System.out.println(sub.charAt(6));
        if(allLetters(letters) && allLetters(lett) && unit01.equals(unit) && dash1 == '-' && dash2 == '-'){
            System.out.println(
                    "\""+
                            sub.trim()+
                            "\","
            );
            original = original.replace(sub.trim(),"");
            }
        }
        return original;
    }
    public static String connections(String original, String pid){
        String[] words = original.split(" ");
        for (int i = 0; i < words.length; i++) {
            String res = "";
            if(words[i].startsWith("PD-")){
                for(int j = i; j< words.length; j++){
                    res+=words[j++]+" ";
                    if(allNumbers(words[j])) break;
                }
                original = original.replace(res.trim(),"");
            }
        }
        return original;
    }
    public static boolean allLetters(String letters) {
        for (int j = 0; j < letters.length(); j++) {
            if(!Character.isLetter(letters.charAt(j))) return false;
        }
        return true;
    }
    public static boolean allNumbers(String numbers) {

        for (int j = 0; j < numbers.length(); j++) {
            if(!Character.isDigit(numbers.charAt(j))) return false;
        }
        return true;
}
}
