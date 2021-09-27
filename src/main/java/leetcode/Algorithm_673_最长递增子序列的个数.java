package leetcode;

import java.util.*;

/**
 *
 */
public class Algorithm_673_最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        if (null == nums) return 0;
        int len = nums.length;
        if (0 == len) return 0;
        if (1 == len) return 1;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        int max = 1;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                } else if (dp[j] + 1 == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                ans = cnt[i];
            } else if (dp[i] == max) {
                ans += cnt[i];
            }

        }
        return ans;
    }


    public static void main(String[] args) {

        Algorithm_673_最长递增子序列的个数 solution = new Algorithm_673_最长递增子序列的个数();

        System.out.println(solution.findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
        System.out.println(solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
