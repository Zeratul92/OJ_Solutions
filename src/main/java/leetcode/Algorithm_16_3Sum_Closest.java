package leetcode;

import java.util.Arrays;

/**
 * <a href='https://leetcode.com/problems/3sum-closest/description/'>16. 3Sum Closest</a>
 */
public class Algorithm_16_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        int minDis = Math.abs(target - ans);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == target) {
                    return temp;
                }
                if (Math.abs(temp - target) < minDis) {
                    minDis = Math.abs(temp - target);
                    ans = temp;
                }
                if (temp > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_16_3Sum_Closest s = new Algorithm_16_3Sum_Closest();
        System.out.println(s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(s.threeSumClosest(new int[]{1,2,3,4,5,6,7}, 10));
    }
}
