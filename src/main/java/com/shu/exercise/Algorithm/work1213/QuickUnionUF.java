package Algorithm.work1213;

public class QuickUnionUF {
    
    private int[] roots;

    public QuickUnionUF(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    public int find(int i) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }
        while (i != roots[i]) {
            int temp = roots[i];
            roots[i] = root;
            i = temp;
        }
        return root;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        roots[pRoot] = qRoot;
    }
}
