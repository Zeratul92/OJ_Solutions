package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Algorithm_508_出现次数最多的子树元素和 {


    public class TreeNode {
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


    public static Map<Long, Integer> map;

    public long getSum(TreeNode node) {
        long sum = node.val;
        if (node.left != null) sum += getSum(node.left);
        if (node.right != null) sum += getSum(node.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        getSum(root);
        int maxTimes = 0;
        for (Long sum : map.keySet()) {
            if (map.get(sum) > maxTimes) maxTimes = map.get(sum);
        }
        Set<Integer> ansSet = new HashSet<>();
        for (Long sum : map.keySet()) {
            if (map.get(sum) == maxTimes) ansSet.add(sum.intValue());
        }
        int[] ret = new int[ansSet.size()];
        int cnt = 0;
        for (Integer ans : ansSet) {
            ret[cnt++] = ans;
        }
        return ret;
    }

    public static void main(String[] args) {

        Algorithm_508_出现次数最多的子树元素和 solution = new Algorithm_508_出现次数最多的子树元素和();


//        System.out.println(solution.fib(12));
    }
}
