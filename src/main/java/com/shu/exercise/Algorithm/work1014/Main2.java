package Algorithm.work1014;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        if(N < 1 || M < 1 || N > 300 || M > 300)
            return;
        int[] limitArray = new int[N];
        for (int i = 0; i < N; i++) {
            limitArray[i] = sc.nextInt();
        }

        int[][] _DegMatrix = new int[M][N];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                _DegMatrix[i][j] = sc.nextInt();

            }
        }
        System.out.println(uniquePath(N, M, limitArray, _DegMatrix));
    }

    public static int uniquePath(int n, int m, int a[], int[][] b){
        int sum = 0;
        int s = m;
        while (s > 0){
            int max = 0, h = 0, l = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(b[i][j] > max){
                        max = b[i][j];
                        h = i;
                        l = j;
                    }
                }
            }
            --a[l];
            if(a[l] == 0){
                for (int i = 0; i < m; i++) {
                    b[i][l] = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                b[h][i] = 0;
            }
            sum = sum + max;
            --s;
        }
        return sum;
    }

}
