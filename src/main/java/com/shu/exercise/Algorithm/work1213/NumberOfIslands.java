package Algorithm.work1213;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
 * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * leetcode 200 https://leetcode-cn.com/problems/number-of-islands/
 */

class UnionFind {
    int count;
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        count = 0;
        parent = new int[rows * cols];
        rank = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    parent[i * cols + j] = i * cols + j;
                    count++;
                }
                rank[i * cols + j] = 0;
            }
        }
    }

    public int find(int num) {
        while (parent[num] != num) {
            num = parent[num];
        }
        return num;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else if (rank[pRoot] < rank[qRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[qRoot] = pRoot;
                rank[pRoot] += 1;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

public class NumberOfIslands {

    // FloodFill法
    // 此题的思路为：遍历二维数组grid，当grid[i][j]为1时就把，该格子极其周围所有为1个格子都置为1（DFS/BFS）同时
    // conut++，遍历完成后count就为岛屿的个数
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int cnt = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j, visited);
//                    bfs(grid, i, j, visited);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if (grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        grid[row][col] = '0';
        visited[row][col] = true;
        if (col + 1 != cols && !visited[row][col+1]) {
            dfs(grid, row, col+1, visited); // 右
        }
        if (col != 0 && !visited[row][col-1]) {
            dfs(grid, row, col-1, visited); // 左
        }
        if(row + 1 != rows && !visited[row+1][col]) {
            dfs(grid, row+1, col, visited); // 下
        }
        if (row != 0 && !visited[row-1][col]) {
            dfs(grid, row - 1, col, visited); // 上
        }
    }

    private void bfs(char[][] grid, int row, int col, boolean[][] visited) {
        Deque<Integer> deque = new LinkedList<>();
        add(deque, grid, row, col, visited);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                int i = deque.poll();
                int j = deque.poll();
                add(deque, grid, i, j, visited);
                grid[i][j] = '0';
                size -= 2;
            }
        }
    }

    private void add(Deque<Integer> deque, char[][] grid, int row, int col ,boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited[row][col] = true;
        if (grid[row][col] == '0') {
            return;
        }
        if (col + 1 != cols && !visited[row][col+1]) {
            deque.add(row); deque.add(col+1); // 右
        }
        if (col != 0 && !visited[row][col-1]) {
            deque.add(row); deque.add(col-1); // 左
        }
        if(row + 1 != rows && !visited[row+1][col]) {
            deque.add(row+1); deque.add(col); // 下
        }
        if (row != 0 && !visited[row-1][col]) {
            deque.add(row-1); deque.add(col); // 上
        }
    }

    // 并查集方法，因为并查集有一个公共的根，此题中可以用搜索到值为‘1’的相邻的点作为一个集
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    int p = row * cols + col;
                    if (row + 1 != rows && grid[row + 1][col] == '1') {
                        uf.union(p, (row + 1) * cols + col);
                    }
                    if (row != 0 && grid[row - 1][col] == '1') {
                        uf.union(p, (row - 1) * cols + col);
                    }
                    if (col + 1 != cols && grid[row][col + 1] == '1') {
                        uf.union(p, row * cols + col + 1);
                    }
                    if (col != 0 && grid[row][col - 1] == '1') {
                        uf.union(p, row * cols + col - 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grid2 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        char[][] grid3 = {
                {'1', '1'},
                {'1', '1'}
        };
        char[][] grid4 = {};
        int res = numberOfIslands.numIslands1(grid3);
        System.out.println(res);
    }
}
