package Algorithm.work1008;

public class Symmetry {

    private static boolean isSymmetrical(TreeNode root){
        return helper(root, root);
    }

    private static boolean helper(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1.value != node2.value)
            return false;
        if(node1 == null || node2 == null)
            return false;
        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        System.out.println(isSymmetrical(n1));
    }
}
