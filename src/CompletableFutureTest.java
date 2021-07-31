import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CompletableFutureTest {

    public static void main(String[] args) {

        CompletableFuture<Integer> cf = new CompletableFuture<>();
        Executor executor = Executors.newCachedThreadPool();
//        Executor executor1 = Executors.newFixedThreadPool(5);
//        cf = CompletableFuture.supplyAsync(()->1,executor1).thenApply(x->x*2).thenApply(x->x*x)
//                .whenComplete((r,e)-> System.out.println(r));

        IntStream stream = new Random().ints(10000);

        int[] arr = new int[100000000];
        ArrayList<Integer> arr2 = new ArrayList<>(10000);
        Arrays.stream(arr).forEach(s-> new Random());
        long time0 = System.currentTimeMillis();
        Arrays.parallelSort(arr);
        System.out.println(System.currentTimeMillis()-time0);

        Arrays.stream(arr).forEach(s-> new Random());
        long time1 = System.currentTimeMillis();
        Arrays.sort(arr);
        System.out.println(System.currentTimeMillis()-time1);
    }
}
