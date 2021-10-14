package leetcode;

import java.util.Arrays;
import java.util.Collections;

/*

 */
public class Algorithm_976_三角形的最大周长 {
    public int largestPerimeter(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = len - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }
        return 0;
    }

    public static void main(String[] args) {


        Algorithm_976_三角形的最大周长 s = new Algorithm_976_三角形的最大周长();
        System.out.println(s.largestPerimeter(new int[]{}));
    }
}
