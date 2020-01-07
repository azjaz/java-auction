package codeWars.samples;

public class AccumulTest {
    public static void main(String[] args) {
        System.out.println(accum("ZpglnRxqenU"));
    }
    public static String accum(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArray = s.toUpperCase().split("");
        for(int i = 0; i < s.length(); i++) {
            sb.append(strArray[i]);
            for (int j = 0; j < i; j++) {
                sb.append(strArray[i].toLowerCase());
            }
        }
        return sb.toString().replaceAll("([A-Z]*)([A-Z]+)", "$1-$2");
    }
}
