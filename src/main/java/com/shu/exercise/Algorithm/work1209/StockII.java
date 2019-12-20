package Algorithm.work1209;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * leetcode122 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class StockII {

    // 贪心
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int res = 0;
        for (int i = 0; i < size - 1; i++) {
            int j = i;
            while (j < size -1 && prices[j+1] >= prices[j]) j++;
            res += prices[j] - prices[i];
            i = j;
        }
        return res;
    }

    // DP
    public int maxProfit1(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size+1][size+1];
        for (int i = 1; i <= size; i++) {
            for (int j = i+1; j <= size; j++) {
                int max = Integer.max(dp[i][j-1], dp[i-1][j]);
                int temp = Integer.max(max, (prices[j-1] - prices[i-1] + dp[i-1][i]));
                System.out.println(temp);
                dp[i][j] = temp;
            }
        }
        return dp[size-1][size];
    }

    public static void main(String[] args) {
        StockII stockII = new StockII();
        int[] prices = {7,1,5,3,6,4};
        int res = stockII.maxProfit1(prices);
        System.out.println(res);
    }
}
