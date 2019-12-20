package Algorithm.work1015;

import java.util.Scanner;

public class Liulishuo2019 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int firstNumber = scanner.nextInt();
        int max = firstNumber;
        int sum = firstNumber;
        for (int i = 1; i < n; i++) {
             int number = scanner.nextInt();
             sum = Math.max(0, sum + number);
             max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
