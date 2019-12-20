package Algorithm.work1012;

import java.util.ArrayList;
import java.util.List;

public class LongestSubSeq {

    List<String> allLCS = new ArrayList<>();

    public static void main(String[] args) {
        String a = "ABCBDAB";
        String b = "BDCABA";

        LongestSubSeq longestSubSeq = new LongestSubSeq();

        int[][] dpMatrix = longestSubSeq.longestCommonSubSeq(a, b);

        longestSubSeq.printAllLCS(a, b, dpMatrix);



    }

    private int[][] longestCommonSubSeq(String a, String b) {
        if(a == null || a.length() == 0 || b == null || b.length() ==0)
            return null;
        int lengthA = a.length();
        int lengthB = b.length();

        int[][] dp = new int[lengthA+1][lengthB+1];
        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp;
    }

    private String reverse(String s){
        if(s == null || s.length() == 0)
            return null;

        int length = s.length();

        char[] chars = s.toCharArray();

        for (int i = 0; i < (length >> 1); i++) {
            char temp = chars[i];
            chars[i] = chars[length - i - 1];
            chars[length - i - 1] = temp;
        }
        return String.valueOf(chars);
    }

    private void printAllLCS(String a, String b, int[][] matrix){
        int beginA = a.length();
        int beginB = b.length();
        String lcs = "";
        helper(a, b, matrix, beginA, beginB, lcs);
        for (String s : allLCS) {
            System.out.println(s);
        }
    }

    private void helper(String a, String b, int[][] matrix, int beginA, int beginB, String lcs) {
        while (beginA > 0 && beginB > 0){
            if(a.charAt(beginA-1) == b.charAt(beginB-1)){
                lcs = a.charAt(beginA-1) + lcs;
                beginA--;
                beginB--;
            } else {
                if(matrix[beginA-1][beginB] > matrix[beginA][beginB-1])
                    beginA--;
                else if(matrix[beginA-1][beginB] < matrix[beginA][beginB-1])
                    beginB--;
                else{
                    helper(a, b, matrix, beginA - 1, beginB, lcs);
                    helper(a, b, matrix, beginA, beginB - 1, lcs);
                    return;
                }
            }
        }
        allLCS.add(lcs);
    }

}
