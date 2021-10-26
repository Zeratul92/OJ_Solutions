package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_746_使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 0);
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Algorithm_746_使用最小花费爬楼梯 s = new Algorithm_746_使用最小花费爬楼梯();
        System.out.println(s.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
