package Algorithm.work1126;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，
 * 使其能够生成所有可能的并且有效的括号组合。
 * 比如n=3，生成结果为
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * leetcode22 https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    // 思路一：用递归的方法随机往字符串中加入左括号或者右括号，
    // 注意3点：1.合法的结果中一定有"("=")"=3；2.一定是左括号起头；3.每次加入左括号前判断”（“<3，加入右括号前判断”）“<3 && <"("

    public List<String> generateParenthesis(int n) {
        ArrayList<String> resList = new ArrayList<>();
        genSupport(0, 0, n, "", resList);
        return resList;
    }

    private void genSupport(int leftUsed, int rightUsed, int n, String s, ArrayList<String> resList) {
        if(leftUsed == n && rightUsed == n) {
            resList.add(s);
            return;
        }
        if(leftUsed < n) {
            genSupport(leftUsed + 1, rightUsed, n, s + "(", resList);
        }
        if(rightUsed < n && rightUsed < leftUsed) {
            genSupport(leftUsed, rightUsed + 1, n, s + ")", resList);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(3);
        System.out.println();
    }
}
