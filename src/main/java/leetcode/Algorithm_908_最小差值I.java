package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_908_最小差值I {
    public int smallestRangeI(int[] nums, int k) {
        int min = 10000;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int ans = max - min - 2 * k;
        return Math.max(ans, 0);
    }

    public static void main(String[] args) {


        Algorithm_908_最小差值I s = new Algorithm_908_最小差值I();
        System.out.println(s.smallestRangeI(new int[]{4, 1, 3}, 1));
        System.out.println(s.smallestRangeI(new int[]{11, 1, 4, 2, 4}, 2));
    }
}
