package Algorithm.work1014;

import java.util.Scanner;

public class Longest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int res = getLongest1Str(arr, K);
        System.out.println(res);
    }

    private static int getLongest1Str(int[] arr, int k) {
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                if(k > 0){
                    right++;
                    k--;
                } else {
                    while (left <= right && arr[left] != 0) left++;
                    left++;
                    right++;
                }
            } else {
                right++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
