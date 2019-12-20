package Algorithm.work1012;

public class LongestSubStr {

    public static void main(String[] args) {
        String a = "ABCBDAB";
        String b = "BBCBDA";

        LongestSubStr longestSubStr = new LongestSubStr();
        System.out.println(longestSubStr.getDPMatrix(a, b));

    }

    private int getDPMatrix(String str, String subStr){
        if(str == null || str.length() <=0 || subStr == null || subStr.length() <= 0)
            return 0;

        int maxLen = 0;

        int len1 = str.length();
        int len2 = subStr.length();

        int dp[][] = new int[len1+1][len2+1];

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if(str.charAt(i-1) == subStr.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > maxLen)
                        maxLen = dp[i][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }
}
