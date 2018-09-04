package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Algorithm_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (pre.length == 1) {
            return root;
        }
        int len = pre.length;
        int leftLen = findIdx(post, pre[1]) + 1;
        int[] leftPre = Arrays.copyOfRange(pre, 1, 1 + leftLen);
        int[] leftPost = Arrays.copyOfRange(post, 0, leftLen);
        int[] rightPre = Arrays.copyOfRange(pre, leftLen + 1, len);
        int[] rightPost = Arrays.copyOfRange(post, leftLen, len - 1);

        root.left = constructFromPrePost(leftPre, leftPost);
        root.right = constructFromPrePost(rightPre, rightPost);
        return root;
    }


    private int findIdx(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Algorithm_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal solution = new Algorithm_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal();
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        TreeNode node = solution.constructFromPrePost(pre, post);
    }
}
