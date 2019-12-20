package Algorithm.work1014;

import java.util.Scanner;

public class Joseph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int rounds = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        joseph(arr, m, rounds, 0);
    }

    private static void joseph(int[] arr, int m, int rounds, int index) {
        if(rounds == 0)
            return;
        int k = m;
        while (m > 1){
            if (arr[index % arr.length] != 0) {
                m--;
                index++;
            } else {
                index++;
            }
        }
        index = index % arr.length;
        int number = arr[index];
        arr[index] = 0;
        joseph(arr, k, rounds - 1, index);
        System.out.println("round" + rounds + ": " + number + " is deleted.");
    }
}
