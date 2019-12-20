package Algorithm.work1013;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class FindPath {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;


        FindPath obj = new FindPath();

        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        obj.findPath(n1, val);

    }

    private void findPath(TreeNode root, int val) {
        if(root == null)
            return;
        List<Integer> res = new ArrayList<>();
        int curSum = 0;
        helper(root, val, res, curSum);
    }

    private void helper(TreeNode node, int val, List<Integer> res, int curSum) {
        curSum += node.value;
        res.add(node.value);

        boolean isLeaf = node.left == null && node.right == null;
        if(val == curSum && isLeaf){
            System.out.print("A path is found: ");
            for (int item : res) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

        if(node.left != null){
            helper(node.left, val, res, curSum);
        }
        if(node.right != null){
            helper(node.right, val, res, curSum);
        }

        res.remove(res.size()-1);
    }

}
