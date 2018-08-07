package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href='https://leetcode.com/problems/3sum/description/'>15. 3Sum</a>
 */
public class Algorithm_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + 2 * nums[l] > 0) {
                    break;
                }
                if (nums[i] + 2 * nums[r] < 0) {
                    break;
                }
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // in case duplicate triplets occur
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (sum > 0) {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_15_3Sum s = new Algorithm_15_3Sum();
        System.out.println(s.threeSum(new int[]{}));
        System.out.println(s.threeSum(new int[]{3, 2, -3, 3, 0, 2, 1, 2, 3, 0}));
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
