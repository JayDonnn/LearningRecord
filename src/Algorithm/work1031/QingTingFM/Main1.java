package Algorithm.work1031.QingTingFM;


/**
 * 蜻蜓FM 笔试题
 * 求一个二叉树中，路劲节点的val的和等于某个值的路径个数（起始点不要求是根节点，结束点不要求是叶子节点）
 * leetcode（437）原题
 */
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Main1 {

    /*
    // 情况一：开始节点可以不为跟节点，结束节点可以不为叶子节点
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int paths(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if(root.val == sum) {
            res += 1;
        }

        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);

        return res;
    }
    */

    // 情况二：开始节点是根节点，结束节点为叶子节点。
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        return paths(root, sum);
    }

    private int paths(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null && root.val == sum) {
            return 1;
        }
        return paths(root.left, sum - root.val) + paths(root.right, sum - root.val);
    }


    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5, n6, n7, n8, n9;
        n1 = new TreeNode(10);
        n2 = new TreeNode(5);
        n3 = new TreeNode(-3);
        n4 = new TreeNode(3);
        n5 = new TreeNode(1);
        n6 = new TreeNode(11);
        n7 = new TreeNode(3);
        n8 = new TreeNode(-2);
        n9 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;

        int sum = 16;
        Main1 main1 = new Main1();
        int res = main1.pathSum(n1, sum);
        System.out.println(res);
    }
}
