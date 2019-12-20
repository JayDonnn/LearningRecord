package Algorithm.work1010;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class PrintTreeFromTopToBottom {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(11);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        printTree(n1);
    }

    private static void printTree(TreeNode root) {
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0){
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
    }
}
