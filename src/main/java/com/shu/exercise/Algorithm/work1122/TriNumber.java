package Algorithm.work1122;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TriNumber {

    public static void main(String[] args) {
        Stream<int []> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.forEach(arr -> System.out.println(arr[0] + "," + arr[1] + "," + arr[2]));
    }
}
