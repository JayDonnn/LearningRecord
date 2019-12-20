package Algorithm.work1105;

import java.util.Stack;

/**
 * 判断一个树是否是一个有效的二叉搜索树
 * leetcode98  https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class ValidateBST {

    /**
     * 利用二叉搜索树的特性：中序遍历得到的序列为升序
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 利用递归
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if(root == null) {
            return true;
        }
        if(lower != null && root.val <= lower) {
            return false;
        }
        if(upper != null && root.val >= upper) {
            return false;
        }
        if(!helper(root.left, lower, root.val) && !helper(root.right, root.val, upper)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5;
        n1 = new TreeNode(0);
        n2 = new TreeNode(5);
        n3 = new TreeNode(15);
        n4 = new TreeNode(6);
        n5 = new TreeNode(20);
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST1(n1));
    }
}
