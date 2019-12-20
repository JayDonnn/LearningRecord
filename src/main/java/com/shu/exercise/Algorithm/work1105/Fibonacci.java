package Algorithm.work1105;

public class Fibonacci {
    public static void main(String[] args) {
        int prev_1 = 1;
        int prev_2 = 1;
        for (int i = 3; i <= 6; i++) {
            int temp = prev_1;
            prev_1 = prev_2;
            prev_2 = temp + prev_2;
        }
        System.out.println(prev_2);
    }
}
