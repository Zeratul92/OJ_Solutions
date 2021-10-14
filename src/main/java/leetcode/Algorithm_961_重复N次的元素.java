package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_961_重复N次的元素 {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        boolean[] ok = new boolean[10000];
        Arrays.fill(ok, false);
        for (int i = 0; i < len; i++) {
            if (ok[nums[i]]) return nums[i];
            ok[nums[i]] = true;
        }
        return -1;
    }

    public static void main(String[] args) {


        Algorithm_961_重复N次的元素 s = new Algorithm_961_重复N次的元素();
        System.out.println(s.repeatedNTimes(new int[]{}));
        System.out.println(s.repeatedNTimes(new int[]{}));
        System.out.println(s.repeatedNTimes(new int[]{}));
    }
}
