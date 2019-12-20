package Algorithm.work1205;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），
 * 设计一个算法来计算你所能获取的最大利润。
 * leetcode 121 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyStock {

    // 方法一：暴力法，两层循环，找出价格正差值最大的两天 时间O(n^2) 空间O(1)
    // 方法二：动态维护minPrice和maxProfit两个变量，用于记录所遍历过的日期中最低的
    // 价格以及遍历过的最大盈利  时间O(n) 空间O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
