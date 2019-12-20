package Algorithm.work1105;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先(祖先可以是节点本身)
 * leetcode235 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestor {

    /*
    思路：1、分别找出根节点到p，q结点的路径（用list保存）；2、从前往后遍历得到的两个list（加入用a，b表示）找到a，b中最后一个相同的节点
    private LinkedList<LinkedList<TreeNode>> paths = new LinkedList<LinkedList<TreeNode>>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = null;
        if(root == null) {
            return null;
        }
        if(p == null && q != null) {
            return q;
        }
        if(p != null && q == null) {
            return p;
        }
        LinkedList<TreeNode> path1 = new LinkedList<>();
        LinkedList<TreeNode> path2 = new LinkedList<>();
        path(root, p, path1);
        path(root, q, path2);
        if(paths.size() != 2) {
            return null;
        } else {
            path1 = paths.get(0);
            path2 = paths.get(1);
            int i = 0, j = 0;
            boolean flag = false;
            for (; i < path1.size() && j < path2.size(); i++, j++) {
                if(path1.get(i) != path2.get(j)) {
                    flag = true;
                    break;
                }
            }

            LCA = path1.get(i - 1);
        }
        return LCA;
    }

    private void path(TreeNode root, TreeNode target, List<TreeNode> list) {
        if(root == null) {
            return;
        }
        list.add(root);
        if(root == target) {
            LinkedList<TreeNode> copy = new LinkedList<>();
            copy.addAll(list);
            paths.add(copy);
        }
        if(root.left != null) {
            path(root.left, target, list);
        }
        if(root.right != null) {
            path(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }*/

    /**
     * 思路2：利用二叉搜索树的性质（左子树的最大值小于等于根节点的值，右子树的最小值大于等于根节点的值）
     * 详细过程如下：
     * 1.利用p，q节点的val和根节点的val比较，大于则在由子树，小于则在左子树；
     * 2.当p，q均在根节点的左（右），则递归的去找根节点的左（右）孩子节点；
     * 3.当p，q分别位于根节点的左右子树，这该根节点就是target节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if(pVal > parentVal && qVal > parentVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(pVal < parentVal && qVal < parentVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n1, n2, n3, n4, n5, n6, n7, n8, n9;
        n1 = new TreeNode(6);
        n2 = new TreeNode(2);
        n3 = new TreeNode(8);
        n4 = new TreeNode(0);
        n5 = new TreeNode(4);
        n6 = new TreeNode(7);
        n7 = new TreeNode(9);
        n8 = new TreeNode(3);
        n9 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        System.out.println(ancestor.lowestCommonAncestor(n1, n2, n5).val);
    }
}
