package Algorithm.work1127;

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i <= 80; i++) {
            int divisor = i / 9;
            int remainder = i % 9;
            System.out.println(divisor + " " + remainder);
        }
    }
}
