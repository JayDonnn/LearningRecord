package Algorithm.work1031.EA;

import java.util.Scanner;

/**
 * EA China笔试题
 * 输入一个数n，求n个节点的完全二叉树有多少种（卡特兰数）
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 0 || n >= 30000){
            System.out.println(0);
            return;
        }
        long c = 1;
        for (int i = 0; i < n; i++) {
            c = c * 2 * (2 * i + 1) / (i + 2);
        }
        System.out.println(c);
    }
}
