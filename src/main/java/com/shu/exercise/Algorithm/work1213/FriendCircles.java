package Algorithm.work1213;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
 * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 * <p>
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，
 * 否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 * <p>
 * leetcode 547 https://leetcode-cn.com/problems/friend-circles/
 */
public class FriendCircles {

    // 填色法
    // 规则：遍历二维数组M，若M[i][j]=1，先将自己置为1，再（BFS/DFS）向边上扩散（将0置为1）
    // BFS:遍历row这一行，先将当前点置为1，再将该行中的其他的为1的点加入队列（视为一个朋友圈），下次遍历队列中的元素
    // 时间复杂度O(N^2)  时间复杂度O(N)
    public int findCircleNum(int[][] M) {
        if (null == M || M.length == 0) {
            return 0;
        }
        int cnt = 0;
        int rows = M.length;
        int cols = M[0].length;
        boolean[] visited = new boolean[rows];
        Queue<Integer> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            if (!visited[row]) {
                cnt++;
                queue.add(row);
                while (!queue.isEmpty()) {
                    int curRow = queue.poll();
                    visited[curRow] = true;
                    for (int i = 0; i < cols; i++) {
                        if (M[curRow][i] == 1 && !visited[i]) {
                            queue.add(i);
                        }
                    }
                }
            }
        }
        return cnt;
    }



    // 并查集法
    // 在本题中，每行可以代表一个人及他的好友情况。
    // 因此在使用并查集时，当检查到点M[i][j]时，可以把i和j做一个union操作（即把他们纳入一个朋友圈），有因为题目中说
    // a->b + b->c => a->c    因此这个想法是成立的
    public int findCircleNum1(int[][] M) {
        int[] parent = new int[M.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < M.length; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        return cnt;
    }

    private void union(int[] parent, int p, int q) {
        int pRoot = findRoot(parent, p);
        int qRoot = findRoot(parent, q);
        if (pRoot != qRoot) {
            parent[pRoot] = qRoot;
        }
    }

    private int findRoot(int[] parent, int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    public static void main(String[] args) {
        FriendCircles fc = new FriendCircles();
        int[][] m1 = {};
        int[][] m2 = {{}};
        int res = fc.findCircleNum(m1);
        System.out.println(res);
    }
}
