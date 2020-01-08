package codeWars.samples;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class FindUniqueNumbers {
    public static void main(String[] args) {
        double[] arr = {1, 1, 1, 2, 1, 1};
        System.out.println(findUniq(arr));
    }
    public static double findUniq(double arr[]) {
        double repeatNumb = arr[0];
        if (arr[1] == repeatNumb) {
            return DoubleStream.of(arr)
                    .boxed()
                    .collect(Collectors.toList())
                    .stream()
                    .distinct()
                    .filter(p -> !p.equals(repeatNumb))
                    .findFirst()
                    .get();
        } else {
            if (arr[2] == repeatNumb)
                return arr[1];
            else return repeatNumb;
        }
    }
}
