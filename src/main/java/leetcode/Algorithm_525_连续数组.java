package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_525_连续数组 {

    public int findMaxLength(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (0 == nums[i]) {
                nums[i] = -1;
            }
        }
        int sum = 0;
        Map<Integer, Integer> firstAppearMap = new HashMap<>();
        Map<Integer, Integer> lastAppearMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (!firstAppearMap.containsKey(sum)) {
                firstAppearMap.put(sum, i);
            } else {
                lastAppearMap.put(sum, i);
            }
        }
//        System.out.println(firstAppearMap);
//        System.out.println(lastAppearMap);

        int ans = 0;
        for (Integer sumFirstAppear : firstAppearMap.keySet()) {
            if (lastAppearMap.containsKey(sumFirstAppear)) {
                ans = Math.max(ans, lastAppearMap.get(sumFirstAppear) - firstAppearMap.get(sumFirstAppear));
            }
        }

        ans = Math.max(ans, firstAppearMap.getOrDefault(0, -1) + 1);
        ans = Math.max(ans, lastAppearMap.getOrDefault(0, -1) + 1);

        return ans;
    }

    public static void main(String[] args) {

        Algorithm_525_连续数组 solution = new Algorithm_525_连续数组();


        System.out.println(solution.findMaxLength(new int[]{1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0, 1, 0, 1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1,}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 0, 1}));
    }
}
