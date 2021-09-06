package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */
public class Algorithm_561_数组拆分I {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

        Algorithm_561_数组拆分I solution = new Algorithm_561_数组拆分I();

        System.out.println(solution.arrayPairSum(new int[]{}));
    }
}
