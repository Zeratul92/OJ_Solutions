package leetcode;

import java.util.Arrays;

/**
 * not finished
 */
public class Algorithm_611_有效三角形的个数 {

    public int find(int[] nums, int upper, int l, int r) {
        int idx = -1;

        int left = l, right = r;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= upper) {
                right = mid;
            } else {
                left = mid + 1;
                idx = mid;
            }
        }
        if (left < nums.length && nums[left] < upper) return left;
        return idx;
    }


    public int triangleNumber(int[] nums) {
        int len = nums.length;
        if (len <= 2) return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < len; j++) {
                int sum = nums[i] + nums[j];
                int idx = find(nums, sum, j + 1, len - 1);
//                System.out.println("两边" + nums[i] + ", " + nums[j]);
//                System.out.println(idx + ": " + ((idx == -1) ? "no" : nums[idx]));
                if (idx == -1) continue;
                ans += idx - j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Algorithm_611_有效三角形的个数 solution = new Algorithm_611_有效三角形的个数();


        System.out.println(solution.triangleNumber(new int[]{2,2,3,4}));
    }
}
