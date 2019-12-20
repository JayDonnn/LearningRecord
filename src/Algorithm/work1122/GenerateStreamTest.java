package Algorithm.work1122;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateStreamTest {

    public static void main(String[] args) {
        // 值创建流
        Stream<String> java = Stream.of("java", "in", "action");
        Stream<Object> empty = Stream.empty();

        // 数组创建流
        int[] arr = {1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);

        // 文件创建流
//        Stream<String> lines = Files.lines();

        // 函数创建流：无限流
        Stream.iterate(new int[]{1, 1}, n -> new int[]{n[1], n[0] + n[1]}).limit(5)
                .forEach(n -> System.out.println("(" + n[0] + "," + n[1] + ")"));

        IntStream.generate(new IntSupplier() {
            private int prev = 1;
            private int cur = 1;
            @Override
            public int getAsInt() {
                int next = prev + cur;
                int old = prev;
                prev = cur;
                cur = next;
                return old;
            }
        }).limit(5).forEach(System.out::println);
    }
}
