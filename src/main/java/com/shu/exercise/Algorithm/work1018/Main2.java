package Algorithm.work1018;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n < 1 || n >= 90)
            return;
        int res = 0;
        res = helper(n+1);
        System.out.println(res);
    }

    private static int helper(int n) {
        if (n <= 1)
            return n;
        int pre2 = 1;
        int pre1 = 1;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
