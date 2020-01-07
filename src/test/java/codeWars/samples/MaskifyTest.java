package codeWars.samples;

public class MaskifyTest {
    public static void main(String[] args) {
        System.out.println(maskify("sdfgh"));
    }
    public static String maskify(String str) {
       if(str.length() <= 4)
           return str;
       else {
           String mask = str.replaceAll(".", "#").substring(0, str.length() - 4);
           return mask + str.substring(str.length() - 4);
       }
    }
}
