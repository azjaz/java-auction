package codeWars.samples;

import java.util.Arrays;

public class PhoneNumberCreator {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(createPhoneNumber(numbers));
    }
    public static String createPhoneNumber(int[] numbers) {
        return Arrays.toString(numbers)
                .replaceAll(", ", "")
                .replaceAll("\\[(\\d+)(\\d{3})(\\d{4})\\]", "($1) $2-$3");
    }
}
