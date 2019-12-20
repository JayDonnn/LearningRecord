package Algorithm.work1128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * leetcode235 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LCAOfBST {

    // 方法一：利用二叉搜索树的性质，每次判断三个参数节点的大小关系
    // 时间复杂度O(logN) 空间复杂度为O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal > rootVal && qVal > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(pVal < rootVal && qVal < rootVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    // 方法二：递归
    // 给每个节点设置三个属性值，分别是left（表示左子树中有p或者q节点），mid（当前节点为p或者q节点），right（表示右子树中有p或者q节点）
    // 下面代码为错误代码
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q, boolean flag) {
        if(root == null) {
            return null;
        }
        TreeNode leftNode = lowestCommonAncestor2(root.left, p, q, flag);
        TreeNode rightNode = lowestCommonAncestor2(root.right, p, q, flag);
        int left = leftNode == p || leftNode == q ? 1 : 0;
        int right = rightNode == q || rightNode == p ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(flag) {
            return root;
        }

        if(left + right + mid >= 2) {
            flag = true;
            return root;
        } else if (mid == 1) {
            return root;
        } else if(left == 1) {
            return leftNode;
        } else if(right == 1) {
            return rightNode;
        } else {
            return null;
        }
    }

    // 方法三：迭代法
    // 通过DFS找到树中的p，q节点，并且在搜索的时候，将路径以Map<ChildNode, ParentNode>的形式存储起来
    // 最后先遍历Map将p或q到根节点的所有父节点加入到一个Set中，再判断另一个节点的父节点是否被包含在Set中
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> paths = new HashMap<>();

        paths.put(root, null);
        stack.push(root);

        while (!paths.containsKey(p) || !paths.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                paths.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null) {
                paths.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestor = new HashSet<>();
        while (!(p == null)) {
            ancestor.add(p);
            p = paths.get(p);
        }

        while (!ancestor.contains(q)) {
            q = paths.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        LCAOfBST lcaOfBST = new LCAOfBST();
        TreeNode n1, n2, n3, n4, n5, n6, n7, n8, n9;
        n1 = new TreeNode(-1);
        n2 = new TreeNode(0);
        n3 = new TreeNode(3);
        n4 = new TreeNode(-2);
        n5 = new TreeNode(4);
        n6 = new TreeNode(8);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n6;

//        System.out.println(lcaOfBST.lowestCommonAncestor(n1, n2, n3).val);
        lcaOfBST.lowestCommonAncestor3(n1, n5, n6);
//        System.out.println(lcaOfBST.lowestCommonAncestor(n1, n2, n5).val);
    }
}
