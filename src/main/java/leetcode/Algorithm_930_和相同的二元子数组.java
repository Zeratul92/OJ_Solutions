package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

 */
public class Algorithm_930_和相同的二元子数组 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            ans += map.getOrDefault(sum - goal, 0);
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_930_和相同的二元子数组 s = new Algorithm_930_和相同的二元子数组();
        System.out.println(s.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));

    }
}
