package leetcode_cn.algorithm_1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/description/
 * Use a HashMap to store the numbers' positions in the array.
 * Created by Zeratul on 2018/7/24.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> posMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - nums[i];
            if (posMap.containsKey(b)) {
                return new int[]{posMap.get(b), i};
            }
            posMap.put(a, i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 9;
        int[] ret = solution.twoSum(new int[]{11, 2, 7, 15},
                target);
        System.out.println(ret[0] + ", " + ret[1]);
    }
}
