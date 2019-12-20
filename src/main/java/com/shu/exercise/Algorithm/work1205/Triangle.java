package Algorithm.work1205;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 答案为2+3+5+1=11
 * leetcode 120 https://leetcode-cn.com/problems/triangle/
 */
public class Triangle {

    // 方法一：递归  时间复杂度O(2^N)
    int rows;
    public int minimumTotal(List<List<Integer>> triangle) {
        rows = triangle.size();
        return dfs(0, 0, triangle);
    }

    private int dfs(int level, int index, List<List<Integer>> triangle) {
        if (level + 1 == rows) {
            return triangle.get(level).get(index);
        }
        int leftSum = dfs(level + 1, index, triangle);
        int rightSum = dfs(level + 1, index + 1, triangle);
        return triangle.get(level).get(index) + Integer.min(leftSum, rightSum);
    }

    // 方法二：带记忆的递归
    public int minimumTotal1(List<List<Integer>> triangle) {
        rows = triangle.size();
        Integer[][] memo = new Integer[rows][rows];
        return dfsWithMemo(0, 0, triangle, memo);
    }

    private int dfsWithMemo(int level, int index, List<List<Integer>> triangle, Integer[][] memo) {
        if (level + 1 == rows) {
            return triangle.get(level).get(index);
        } else if (memo[level][index] != null) {
            return memo[level][index];
        } else {
            int leftSum = dfsWithMemo(level + 1, index, triangle, memo);
            int rightSum = dfsWithMemo(level + 1, index + 1, triangle, memo);
            memo[level][index] = Integer.min(leftSum, rightSum) + triangle.get(level).get(index);
        }
        return memo[level][index];
    }

    // 方法三：动态规划（tips：自底向上递推）
    // 从下往上累加，由于题目中相邻的约束，所以有递推式 i层第j个位置当前的累计最小值 = min(ai+1,j:ai+1,j+1) + ai,j
    // 时间复杂度O(N^2) 空间复杂度O(N)
    public int minimumTotal2(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows + 1];
        for (int level = rows - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                dp[i] = Integer.min(dp[i], dp[i + 1]) + triangle.get(level).get(i);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        List<List<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6); list3.add(5); list3.add(7);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4); list4.add(1); list4.add(8); list4.add(3);
        input.add(list1); input.add(list2); input.add(list3); input.add(list4);
        System.out.println(triangle.minimumTotal1(input));
    }
}
