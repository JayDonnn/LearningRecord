package Algorithm.work1126;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后问题
 * leetcode51 https://leetcode-cn.com/problems/n-queens/
 */

public class NQueens {

    /*
     * 经验：在一个二维数组中存在一个规律
     * 假设某个数的下标为(i,j)，则在该位置的正斜线上所有元素的下标之和等于i+j,反斜线上所有元素的下标之和等于i-j
     * backtrack(row = 0).
     * 从第一个 row = 0 开始.
     * 循环列并且试图在每个 column 中放置皇后.
     *    如果方格 (row, column) 不在攻击范围内
     *       在 (row, column) 方格上放置皇后。
     *       排除对应行，列和两个对角线的位置。
     *       If 所有的行被考虑过，row == N
     *          意味着我们找到了一个解
     *       Else
     *          继续考虑接下来的皇后放置 backtrack(row + 1).
     * 回溯：将在 (row, column) 方格的皇后移除.
     * 时间复杂度为O(N!)，空间复杂度为O(N)
     */
    int n;
    int cols[];
    int pie[];
    int na[];
    int queens[];
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = new int[n];
        pie = new int[2 * n - 1];
        na = new int[4 * n - 1];  //因为i-j的结果可能为负数，所以下面算法中都加了2n
        queens = new int[n];
        backtrace(0);
        return res;
    }

    private void backtrace(int row) {
        for (int col = 0; col < n; col++) {
            if(cols[col] + pie[row + col] + na[row - col + 2 * n] == 0) {
                placeQueen(row, col);
                if(row + 1 == n) {
                    addSolution();
                } else {
                    backtrace(row + 1);
                }
                removeQueen(row, col);
            }
        }
    }

    private void removeQueen(int row, int col) {
        queens[row] = 0;
        cols[col] = 0;
        pie[row + col] = 0;
        na[row - col + 2 * n] = 0;
    }

    private void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int col = queens[i];
            for (int j = 0; j < col; j++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int j = col + 1; j < n; j++) {
                sb.append('.');
            }
            solution.add(sb.toString());
        }
        res.add(solution);
    }

    private void placeQueen(int row, int col) {
        queens[row] = col;
        cols[col] = 1;
        pie[row + col] = 1;
        na[row - col + 2 * n] = 1;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(4);
    }

}
