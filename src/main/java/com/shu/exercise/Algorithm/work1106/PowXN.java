package Algorithm.work1106;

import java.util.Scanner;

/**
 * 实现 pow(x, n)
 * leetcode50 https://leetcode-cn.com/problems/powx-n/
 */
public class PowXN {

    public double fastPow(double x, int n) {
        if(n == 1) {
            return x;
        }
        double temp = fastPow(x, n / 2);
        if(n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    public double myPow(double x, int n) {
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        return fastPow(x, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PowXN powXN = new PowXN();
        double x;
        int n;
        while (true) {
            x = scanner.nextDouble();
            n = scanner.nextInt();
            double res = powXN.myPow(x, n);
            if(n < 0) {
                res = 1.0 / res;
            }
            System.out.printf("%.5f", res);
        }
    }
}
