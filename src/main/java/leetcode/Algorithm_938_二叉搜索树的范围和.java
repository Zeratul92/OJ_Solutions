package leetcode;

/*

 */
public class Algorithm_938_二叉搜索树的范围和 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val > high) return rangeSumBST(root.left, low, high);
        if (root.val < low) return rangeSumBST(root.right, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {
        Algorithm_938_二叉搜索树的范围和 s = new Algorithm_938_二叉搜索树的范围和();
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node18 = new TreeNode(18);

        node10.left = node5;
        node10.right = node15;
        node5.left = node3;
        node5.right = node7;
        node15.right = node18;
        System.out.println(s.rangeSumBST(node10, 7, 15));
    }
}


