package Algorithm.work1008;

public class MirrorTree {

    private static TreeNode getMirrorTree(TreeNode root){
        if(root == null)
            return null;
        if(root.left != null || root.right != null){
            TreeNode temp = root.right;
            root.right = getMirrorTree(root.left);
            root.left = getMirrorTree(temp);
        }
        return root;
    }

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

        getMirrorTree(n1);
        System.out.println();
    }
}
