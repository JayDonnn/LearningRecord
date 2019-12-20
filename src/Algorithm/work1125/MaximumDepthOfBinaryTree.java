package Algorithm.work1125;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    // 方法一：层次遍历（即从上往下算数的深度）
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if(null == root) {
            return maxDepth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int batchSize = queue.size();
            while (batchSize > 0) {
                TreeNode temp = queue.poll();
                if(null != temp.left) queue.offer(temp.left);
                if(null != temp.right) queue.offer(temp.right);
                batchSize--;
            }
            maxDepth++;
        }
        return maxDepth;
    }

    // 方法二：Depth First Search（即从下往上回推树的深度）
    public int maxDepth1(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);
        return Integer.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5;
        n1 = new TreeNode(3);
        n2 = new TreeNode(9);
        n3 = new TreeNode(20);
        n4 = new TreeNode(15);
        n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        maximumDepthOfBinaryTree.maxDepth(n1);
    }
}
