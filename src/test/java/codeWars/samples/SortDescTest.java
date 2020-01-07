package codeWars.samples;

import java.util.Arrays;
import java.util.Comparator;

public class SortDescTest {
    public static void main(String[] args) {
        System.out.println(sortDesc(501));
    }
    public static int sortDesc(final int num) {
        StringBuilder sb = new StringBuilder();
        Arrays.asList(String.valueOf(num).split(""))
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(sb::append);
        String string = sb.toString();
        long result = Long.valueOf(string);
        if(result <= Integer.MAX_VALUE)
            return (int) result;
        else return Integer.MAX_VALUE;

    }
}
