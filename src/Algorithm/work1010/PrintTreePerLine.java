package Algorithm.work1010;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreePerLine {
    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5, n6, n7;
        n1 = new TreeNode(8);
        n2 = new TreeNode(6);
        n3 = new TreeNode(10);
        n4 = new TreeNode(5);
        n5 = new TreeNode(7);
        n6 = new TreeNode(9);
        n7 = new TreeNode(11);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
//        n3.left = n6;
        n3.right = n7;
        n7.left = n6;

        printTree(n1);
    }

    private static void printTree(TreeNode root) {
        if(root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                System.out.print(node.value + " ");
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                size--;
            }
            System.out.println();
        }
    }
}
