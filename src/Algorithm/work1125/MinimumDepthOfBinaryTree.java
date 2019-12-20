package Algorithm.work1125;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最小深度
 * leetcode111 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
    // 思路一：层次遍历，用一个变量“minDepth”记录当前的层数，
    // 当遍历到一个节点其左、右孩子均不存在，返回minDepth
    // 优点是：不必遍历每一个节点


    // 思路二：递归法
    public int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if(leftDepth == 0 && rightDepth != 0) {
            return rightDepth + 1;
        } else if(leftDepth != 0 && rightDepth == 0) {
            return leftDepth + 1;
        } else {
            return Integer.min(leftDepth, rightDepth) + 1;
        }
    }

    // 思路三：用栈实现DFS
    public int minDepth1(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if(null == root) {
            return 0;
        }
        stack.add(new Pair(root, 1));

        int minDepth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            TreeNode node = current.getKey();
            int depth = current.getValue();
            if(node.left == null && node.right == null) {
                minDepth = Integer.min(minDepth, depth);
            }
            if(node.left != null) {
                stack.add(new Pair(node.left, depth + 1));
            }
            if(node.right != null) {
                stack.add(new Pair(node.right, depth + 1));
            }
        }
        return minDepth;
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

        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        minimumDepthOfBinaryTree.minDepth1(n1);
    }


}
