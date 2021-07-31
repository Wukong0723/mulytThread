import java.util.Arrays;

public class Java8 {
    public static void main(String[] args) {
//        int[] arr = new int[10];
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(arr).forEach(System.out::println);

    }
}
