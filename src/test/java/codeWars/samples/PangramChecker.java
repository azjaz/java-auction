package codeWars.samples;

import java.util.Arrays;

public class PangramChecker {
    public static void main(String[] args) {
        System.out.println(check("The quick brown fox jumps over the lazy dog."));
    }
    public static boolean check(String sentence){
        return Arrays
                .stream(sentence.replaceAll("[^a-zA-Z]", "").toLowerCase().split(""))
                .distinct()
                .count() == 26;
    }
}
