package leetcode;

public class Algorithm_53_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Algorithm_53_Maximum_Subarray s = new Algorithm_53_Maximum_Subarray();
        System.out.println(s.maxSubArray(new int[]{1,2,3}));
    }
}
