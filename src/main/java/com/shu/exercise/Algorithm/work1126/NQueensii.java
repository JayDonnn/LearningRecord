package Algorithm.work1126;

/**
 * 输入一个n，判断n皇后总共有几种棋盘摆法
 * leetcode52 https://leetcode-cn.com/problems/n-queens-ii/
 */

public class NQueensii {

    int n;
    int cols[];   // 用于表示矩阵中，该列不能再放其他皇后
    int pie[]; // 用于表示该主对角线不能再放其他皇后
    int na[]; // 用于该次对角线不能再放其他皇后
    int cnt;

    public int totalNQueens(int n) {
        cnt = 0;
        this.n = n;
        cols = new int[n];
        pie = new int[2 * n - 1];
        na = new int[4 * n - 1];
        backtrace(0);
        return cnt;
    }

    private void backtrace(int row) {
        for (int col = 0; col < n; col++) {
            if(cols[col] + pie[row + col] + na[row - col + 2 * n] == 0) {
                cols[col] = 1;
                pie[row + col] = 1;
                na[row - col + 2 * n] = 1;
                if(row + 1 == n) {
                    cnt++;
                } else {
                    backtrace(row + 1);
                }
                cols[col] = 0;
                pie[row + col] = 0;
                na[row - col + 2 * n] = 0;
            }
        }
    }

    public static void main(String[] args) {
        NQueensii nQueensii = new NQueensii();
        System.out.println(nQueensii.totalNQueens(4));
    }

}
