package Algorithm.work1010;

import java.util.Stack;

public class PrintTreeZ {
    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n6 = new TreeNode(6);
        n7 = new TreeNode(7);
        n8 = new TreeNode(8);
        n9 = new TreeNode(9);
        n10 = new TreeNode(10);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        n5.left = n10;

        printZ(n1);
    }

    private static void printZ(TreeNode root) {
        if(root == null)
            return;
        int level = 1;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if(level % 2 != 0){
                while (!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    System.out.print(node.value + " ");
                    if(node.left != null) stack2.push(node.left);
                    if(node.right != null) stack2.push(node.right);
                }
            } else {
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    System.out.print(node.value + " ");
                    if(node.left != null) stack1.push(node.right);
                    if(node.right != null) stack1.push(node.left);
                }
            }
            level++;
            System.out.println();
        }

    }
}
