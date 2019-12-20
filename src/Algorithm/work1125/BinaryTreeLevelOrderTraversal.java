package Algorithm.work1125;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值
 * leetcode102 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeLevelOrderTraversal {

    // 方法一： 迭代
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
                size--;
            }
            resList.add(list);
        }
        return resList;
    }

    // 方法二： 递归
    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(null == root) {
            return levels;
        }
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        int size = levels.size();
        if(levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root.val);
        if(null != root.left) {
            helper(root.left, level + 1);
        }
        if(null != root.right) {
            helper(root.right, level + 1);
        }
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

        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> res = traversal.levelOrder(n1);
        System.out.println();
    }
}
