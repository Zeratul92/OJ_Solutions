package leetcode;

/**
 * not finished
 */
public class Algorithm_606_根据二叉树创建字符串 {
    private static class TreeNode {
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

    public void dfs(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (null == node.left && null == node.right) {
        } else if (null == node.left) {
            sb.append("()(");
            dfs(node.right, sb);
            sb.append(")");
        } else if (null == node.right) {
            sb.append("(");
            dfs(node.left, sb);
            sb.append(")");
        } else {
            sb.append("(");
            dfs(node.left, sb);
            sb.append(")(");
            dfs(node.right, sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public static void main(String[] args) {

        Algorithm_606_根据二叉树创建字符串 solution = new Algorithm_606_根据二叉树创建字符串();


        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        System.out.println(solution.tree2str(node1));
    }
}

