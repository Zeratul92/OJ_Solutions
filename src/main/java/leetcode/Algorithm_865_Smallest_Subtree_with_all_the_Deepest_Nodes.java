package leetcode;

public class Algorithm_865_Smallest_Subtree_with_all_the_Deepest_Nodes {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth = getDepth(root);
        if (depth == 1) {
            return root;
        }
        return findSubtree(root, depth, 1);
    }

    private boolean containDeepest(TreeNode node, int depth, int cur) {
        if (node == null) {
            return false;
        }
        if (cur == depth) {
            return true;
        }
        return containDeepest(node.left, depth, cur + 1) || containDeepest(node.right, depth, cur + 1);
    }

    private TreeNode findSubtree(TreeNode node, int depth, int cur) {
        if (node == null) {
            return null;
        }
        if (depth == cur) {
            return node;
        }

        boolean b1 = containDeepest(node.left, depth, cur + 1);
        boolean b2 = containDeepest(node.right, depth, cur + 1);
        if (b1 && b2) {
            return node;
        }
        if (b1) {
            return findSubtree(node.left, depth, cur + 1);
        } else {
            return findSubtree(node.right, depth, cur + 1);
        }

    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        Algorithm_865_Smallest_Subtree_with_all_the_Deepest_Nodes s = new Algorithm_865_Smallest_Subtree_with_all_the_Deepest_Nodes();
        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }

        nodes[3].left = nodes[5];
        nodes[3].right = nodes[1];

        nodes[5].left = nodes[6];
        nodes[5].right = nodes[2];

        nodes[2].left = nodes[7];
        nodes[2].right = nodes[4];

        nodes[1].left = nodes[0];
        nodes[1].right = nodes[8];

        TreeNode subtree = s.subtreeWithAllDeepest(nodes[3]);
        System.out.println(subtree.val);
    }
}
