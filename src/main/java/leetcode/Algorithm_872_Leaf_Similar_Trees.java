package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Algorithm_872_Leaf_Similar_Trees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getLeaf(root1, list1);
        getLeaf(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeaf(TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        if (node.left != null) {
            getLeaf(node.left, list);
        }
        if (node.right != null) {
            getLeaf(node.right, list);
        }
    }


    public static void main(String[] args) {
        Algorithm_872_Leaf_Similar_Trees s = new Algorithm_872_Leaf_Similar_Trees();
    }
}
