package Algorithm.work1208;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * leetcode 97 https://leetcode-cn.com/problems/interleaving-string/
 */
public class InterleavingString {

    // 暴力法(回溯法)
    // 每次向subStr中加入s1或s2中的一个字符，当subStr equals s3就返回True，全部情况递归完后返回False；
    // 时间复杂度：O(2^(m+n)) m 是s1的长度，n是s2的长度。
    // 空间复杂度：O(m+n) 递归栈的深度最多为 m+n
    public boolean isInterleave(String s1, String s2, String s3) {
        return isIntSupporty(s1, 0, s2, 0, "", s3);
    }

    private boolean isIntSupporty(String s1, int i, String s2, int j, String subStr, String s3) {
        if (s3.equals(subStr) && s1.length() == i && s2.length() == j) {
            return true;
        }
        boolean res = false;
        if (i < s1.length()) {
            res |= isIntSupporty(s1, i + 1, s2, j, subStr + s1.charAt(i), s3);
        }
        if (j < s2.length()) {
            res |= isIntSupporty(s1, i, s2, j + 1, subStr + s2.charAt(j), s3);
        }
        return res;
    }

    // 方法二：记忆化回溯

    // 方法三：二维数组的DP
    public boolean isInterleave1(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else {
                    dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) ||
                            (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    // 方法四 用一维数组（滚动数组）DP
    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[] dp = new boolean[len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j-1) == s3.charAt(i+j-1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1);
                } else {
                    dp[j] = (dp[j - 1] && s2.charAt(j-1) == s3.charAt(i+j-1))
                            || (dp[j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[len2];
    }


    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean res = interleavingString.isInterleave2(s1, s2, s3);
        System.out.println(res);
    }
}
