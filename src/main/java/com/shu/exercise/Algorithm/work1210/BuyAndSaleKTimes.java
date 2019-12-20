package Algorithm.work1210;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 例如
 * 输入:[2,4,1], k = 2    输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * leetcode188 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BuyAndSaleKTimes {

    public int maxProfit(int k, int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int size = prices.length;
        int[][][] dp = new int[size+1][k+1][2];
        /**
         * 定义初始状态：
         * 1.dp[0][k][0] = 0;  因为i是从1开始的，所以i=0表示还未开始，这时候利润肯定为0
         * 2.dp[0][k][1] = -infinity;  代表刚开始是不可能持有股票的，同时考虑到DT方程（max(dp[i-1][j][0], dp[i-1][j][1] + prices[i-1])），此时必须设置为-infinity
         * 3.dp[i][0][0] = 0;   因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0
         * 4.dp[i][0][1] = -infinity;  不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能
         */
        for (int i = 0; i <= size; i++) {
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Integer.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i-1]);
                dp[i][j][1] = Integer.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i-1]);
            }
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            if (dp[size][i][0] > res) {
                res = dp[size][i][0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BuyAndSaleKTimes buyAndSaleKTimes = new BuyAndSaleKTimes();
        int k = 2;
        int nums[] = {2, 4, 1};
        int res = buyAndSaleKTimes.maxProfit(k, nums);
        System.out.println(res);
    }
}
