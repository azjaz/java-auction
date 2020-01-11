package codeWars.samples;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class CountingDups {
    public static void main(String[] args) {
        System.out.println(duplicateCount("indivisibility"));
    }
    public static int duplicateCount(String text) {
        Set<String> unique = new HashSet<>();
        return (int)Stream.of(text.toLowerCase().split(""))
                .filter(p -> !unique.add(p))
                .distinct()
                .count();
    }
}
