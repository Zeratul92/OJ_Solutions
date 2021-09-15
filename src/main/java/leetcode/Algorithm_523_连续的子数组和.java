package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_523_连续的子数组和 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int remainder = 0;
        Map<Integer, Integer> firstIdxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            remainder = (remainder + nums[i]) % k;
            if (remainder == 0 && i >= 1) {
                return true;
            }

//            firstIdxMap.putIfAbsent(remainder, i);
//            if (i - firstIdxMap.get(remainder) >= 2) {
//                return true;
//            }
            if (!firstIdxMap.containsKey(remainder)) {
                firstIdxMap.put(remainder, i);
            } else {
                int firstIdx = firstIdxMap.get(remainder);
                if (i - firstIdx >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Algorithm_523_连续的子数组和 solution = new Algorithm_523_连续的子数组和();

        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 2, 4, 7}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 2, 3, 7}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 2, 3, 6}, 6));
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
        System.out.println(solution.checkSubarraySum(new int[]{2,4,3}, 6));

    }
}
