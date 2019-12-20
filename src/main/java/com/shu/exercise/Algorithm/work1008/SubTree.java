package Algorithm.work1008;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }
}

public class SubTree {

    private static boolean isSubTree(TreeNode n1, TreeNode n2){
        boolean flag = false;
        if(n1 == null || n2 == null) {
            return false;
        } else if(n1.value == n2.value){
            flag = helper(n1, n2);
        }
        if(flag)
            return true;
        else
            return isSubTree(n1.left, n2) || isSubTree(n1.right, n2);
    }

    private static boolean helper(TreeNode n1, TreeNode n2){
        if(n2 == null){
            return true;
        } else if(n1 != null && n2 != null && n1.value == n2.value){
            return helper(n1.left, n2.left) && helper(n1.right, n2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
//        TreeNode n6 = new TreeNode(8);
//        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(2);

        n1.left = n2;
        n2.right = n3;
        n3.left = n4;
        n4.left = n5;

        n8.right = n9;
        n9.left = n10;

        System.out.println(isSubTree(n1, n8));
    }
}
