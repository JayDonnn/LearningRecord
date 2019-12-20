package Algorithm.work1213;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作： 1.插入一个字符； 2.删除一个字符； 3.替换一个字符
 * leetcode72 https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {

    // BFS
    public int minDistance(String word1, String word2) {
        return 0;
    }

    // DP
    public int minDistance1(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i) != word2.charAt(j)) {
                    dp[i][j] = 1 + Integer.min(
                            Integer.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);//三个参数分别代表删除，插入和替换
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[len1][len2];
    }
}
