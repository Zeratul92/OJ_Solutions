package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Algorithm_637_二叉树的层平均值 {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void dfs(TreeNode node, int level, Map<Integer, List<Double>> map) {
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add((double) node.val);
        if (null != node.left) {
            dfs(node.left, level + 1, map);
        }
        if (null != node.right) {
            dfs(node.right, level + 1, map);
        }

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Map<Integer, List<Double>> map = new HashMap<>();
        dfs(root, 0, map);
        for (int i = 0; ; i++) {
            if (!map.containsKey(i)) break;
            List<Double> list = map.get(i);
            double sum = 0;
            for (double val : list) {
                sum += val;
            }
            ret.add(sum / list.size());
        }
        return ret;
    }

    public static void main(String[] args) {
        Algorithm_637_二叉树的层平均值 solution = new Algorithm_637_二叉树的层平均值();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(solution.averageOfLevels(node1));
    }
}


