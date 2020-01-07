package codeWars.samples;


public class FindOutlierTest {
    public static void main(String[] args) {
        int[] arr = {2, 4, 0, 100, 4, 11, 2602, 36};
        System.out.println(find(arr));
    }
    static int find(int[] integers){
        int count = 0;
        int result = 0;
        for (int i = 0; i < 3; i++) {
            switch (integers[i]%2) {
                case 0 : count++;
                break;
                default: count--;
            }
        }
        if (count <= 0) {
            for (int j = 0; j < integers.length; j++) {
                if(integers[j]%2 == 0) {
                    result = integers[j];
                    break;
                }
            }
        } else {
            for (int j = 0; j < integers.length; j++) {
                if(integers[j]%2 != 0) {
                    result = integers[j];
                    break;
                }
            }
        }
        return result;
    }
}
