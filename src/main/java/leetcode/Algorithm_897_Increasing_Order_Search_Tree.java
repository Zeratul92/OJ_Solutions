package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm_897_Increasing_Order_Search_Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        add(root, list);
        if (list.isEmpty()) {
            return null;
        }
        TreeNode top = list.get(0);
        TreeNode cur = top;
        for (int i = 1; i < list.size(); i++) {
            cur.left = null;
            cur.right = list.get(i);
            cur = list.get(i);
        }
        cur.left = null;
        cur.right = null;
        return top;
    }

    private void add(TreeNode node, List<TreeNode> list) {
        if (node.left != null) {
            add(node.left, list);
        }
        list.add(node);
        if (node.right != null) {
            add(node.right, list);
        }
    }

}
