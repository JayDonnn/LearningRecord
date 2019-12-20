package Algorithm.work1024;

import java.util.Scanner;

public class DecodingKinds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.charAt(0) == '0') System.out.println(0);;
        int[] dp = new int[input.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= input.length(); i++) {
            //如果该位不为'0'，说明该位单独成字母合法
            if (input.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //如果后两位能组成"1x"（x为任意数字）或者"2x"（x小于7），说明最后两位组成字母合法
            if ((input.charAt(i - 2) == '1') || (input.charAt(i - 2) == '2' && input.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        System.out.println(dp[input.length()]);
    }
}
