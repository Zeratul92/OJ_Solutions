package leetcode;

import java.util.Arrays;

/**
 * not finished
 */
public class Algorithm_645_错误的集合 {

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ret = new int[2];
        boolean[] flag = new boolean[n + 1];
        for (int num : nums) {
            if (!flag[num]) {
                flag[num] = true;
            } else {
                ret[0] = num;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (!flag[i]) {
                ret[1] = i;
                break;
            }
        }
        return ret;
    }




    public static void main(String[] args) {

        Algorithm_645_错误的集合 solution = new Algorithm_645_错误的集合();
        int[] ans = solution.findErrorNums(new int[]{1,2,3,3});
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println(solution.findErrorNums(new int[]{2,2,3,4}));
    }
}
