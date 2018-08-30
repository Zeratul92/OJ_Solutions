package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Algorithm_894_All_Possible_Full_Binary_Trees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ret = new ArrayList<>();
        if (N == 1) {
            ret.add(new TreeNode(0));
            return ret;
        }
        for (int i = 1; i < N; i += 2) {
            int j = N - i - 1;
            for (TreeNode left : allPossibleFBT(i)) {
                for (TreeNode right : allPossibleFBT(j)) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Algorithm_894_All_Possible_Full_Binary_Trees solution = new Algorithm_894_All_Possible_Full_Binary_Trees();
    }
}
