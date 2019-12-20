package Algorithm.work1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MingExamine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        int[] a = new int[n+1];
        int[] q = new int[n+1];
        int[] b = new int[n+1];

        for (int i = 1; i <= n; i++) {
            String[] inputs = br.readLine().split(" ");
            p[i] = Integer.parseInt(inputs[0]);
            a[i] = Integer.parseInt(inputs[1]);
            q[i] = Integer.parseInt(inputs[2]);
            b[i] = Integer.parseInt(inputs[3]);
        }

        int[][] dp = new int[n+1][121];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 120; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= p[i] && j < q[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-p[i]] + a[i]);
                if(j >= q[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-q[i]] + b[i]);
            }
        }
        System.out.println(dp[n][120]);
    }
}
