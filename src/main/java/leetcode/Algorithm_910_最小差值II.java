package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_910_最小差值II {
    public int smallestRangeII(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[len - 1] - nums[0];
        for (int i = 0; i < len - 1; i++) {
            ans = Math.min(ans, Math.abs(Math.max(nums[i] + k, nums[len - 1] - k) - Math.min(nums[i + 1] - k, nums[0] + k)));
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_910_最小差值II s = new Algorithm_910_最小差值II();
        System.out.println(s.smallestRangeII(new int[]{4, 1, 3}, 1));
        System.out.println(s.smallestRangeII(new int[]{11, 1, 4, 2, 4}, 2));
    }
}
