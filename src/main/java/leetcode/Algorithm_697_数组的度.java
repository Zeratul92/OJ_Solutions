package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Algorithm_697_数组的度 {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        int maxDegree = 0;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            degree.put(num, degree.getOrDefault(num, 0) + 1);
            maxDegree = Math.max(maxDegree, degree.get(num));
            if (!first.containsKey(num)) {
                first.put(num, i);
            }
            last.put(num, i);
        }
        int ans = len;
        for (int num : degree.keySet()) {
            if (degree.get(num) == maxDegree) {
                ans = Math.min(ans, last.get(num) - first.get(num) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_697_数组的度 solution = new Algorithm_697_数组的度();
        System.out.println(solution.findShortestSubArray(new int[]{1,2,2,1}));
    }
}


