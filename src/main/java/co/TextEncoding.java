package co;

import java.nio.charset.Charset;

public class TextEncoding {
    public static String convertStringEncoding(String input, String targetEncoding) {
        try {
            byte[] bytes = input.getBytes();
            return new String(bytes, Charset.forName(targetEncoding));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
