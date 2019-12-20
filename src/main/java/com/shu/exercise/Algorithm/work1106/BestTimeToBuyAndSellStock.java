package Algorithm.work1106;

import java.util.Scanner;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
 * leetcode122 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if(prices == null || prices.length < 2) {
            return maxProfit;
        }
        int buyPrice = prices[0], sellPrice = prices[0];
        int i = 0;
        while (i < prices.length) {
            while (i < prices.length && sellPrice <= prices[i]) {
                sellPrice = prices[i];
                i++;
            }
            maxProfit += sellPrice - buyPrice;
            if(i >= prices.length) {
                break;
            }
            buyPrice = prices[i];
            sellPrice = prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}
