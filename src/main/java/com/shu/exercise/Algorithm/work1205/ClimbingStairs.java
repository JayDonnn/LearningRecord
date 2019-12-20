package Algorithm.work1205;

/**
 *  爬楼梯，一次可以走一步或者两步
 *  leetcode 70 https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
 */
public class ClimbingStairs {

    // 方法一：递归 时间O(2^n) 空间O(n)
    // 方法二：记忆化递归 时间O(n) 空间O(n)
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return cliSup(n, memo);
    }

    private int cliSup(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        } else {
            memo[n] = cliSup(n-1, memo) + cliSup(n-2, memo);
        }
        return memo[n];
    }
    // 方法三：循环迭代法 时间O(n) 空间O(1)
    // 方法四：动态规划 时间O(n) 空间O(n)
    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int a = climbingStairs.climbStairs1(5);
        System.out.println(a);
    }
}
