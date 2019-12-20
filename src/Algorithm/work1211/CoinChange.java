package Algorithm.work1211;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * leetcode322 https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    // 方法1：DP求解
    public int coinChange(int[] coins, int amount) {
        if (null == coins || coins.length == 0 || amount < 0) {
            return -1;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (dp[i-coins[j]] != Integer.MAX_VALUE) {
                        cost = Integer.min(dp[i - coins[j]] + 1, cost);
                    }
                }
            }
            dp[i] = cost;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // 方法2：回溯法暴力求解
    public int coinChange1(int[] coins, int amount) {
        if (null == coins || coins.length == 0 || amount < 0) {
            return -1;
        }
        coins = Arrays.stream(coins).mapToObj(Integer::valueOf).sorted((i1, i2) -> i2 -i1).mapToInt(Integer::intValue).toArray();
        return coiSup(coins, 0, amount);
    }

    private int coiSup(int[] coins, int index, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (index < coins.length && amount > 0) {
            int minCoins = Integer.MAX_VALUE;
            int curCoins = amount / coins[index];
            for (int i = 0; i <= curCoins; i++) {
                int res = coiSup(coins, index + 1, amount - i * coins[index]);
                if (res != -1) {
                    minCoins = Math.min(minCoins, res + i);
                }
            }
            return minCoins == Integer.MIN_VALUE ? -1 : minCoins;
        }
        return -1;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 4;
        int res1 = coinChange.coinChange(coins, amount);
        int res2 = coinChange.coinChange1(coins, amount);
        System.out.println(res1 == res2);
    }
}
