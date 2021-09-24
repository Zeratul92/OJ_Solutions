package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 */
public class Algorithm_560_和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int tempSum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            tempSum += nums[i];
            map.putIfAbsent(tempSum, new ArrayList<>());
            map.get(tempSum).add(i);
        }
//        System.out.println(map);
        int ans = 0;
        for (int key : map.keySet()) {
            if (!map.containsKey(key + k)) {
                continue;
            }
            List<Integer> listI = map.get(key);
            List<Integer> listJ = map.get(key + k);

            System.out.println("presum: " + key + ": " + listI);
            System.out.println("presum: " + (key + k) + ": " + listJ);
            System.out.println();
            int lenI = listI.size();
            int lenJ = listJ.size();
            int i = 0, j = 0;
            while (i < lenI && j < lenJ) {
                int idxI = listI.get(i);
                int idxJ = listJ.get(j);
                if (idxI < idxJ) {
                    ans += lenJ - j;
                    i++;
                } else {
                    j++;
                }
            }
        }
        if (map.containsKey(k)) {
            ans += map.get(k).size();
        }
        return ans;
    }

    public static void main(String[] args) {

        Algorithm_560_和为K的子数组 solution = new Algorithm_560_和为K的子数组();

        System.out.println(solution.subarraySum(
                new int[]{1, 2, 3, 2, 3, 6, 2, 1, 2, 3, 3,
                        -10, -4, 1, 2, -2,-4, -4, 2, -2, -3,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        -10, 3, 1, -20, -3, 2, 3, -1, -1, 2,
                        3, -1, -1, -1, -1, -1, 3, -12, -1, 3,
                        -10, 3, 1, -20, -3, 2, 3, -1, -1, 2,
                        3, -1, -1, -1, -1, -1, 3, -12, -1, 3,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        -10, 3, 1, -20, -3, 2, 3, -1, -1, 2,
                        3, -1, -1, -1, -1, -1, 3, -12, -1, 3,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        -10, 3, 1, -20, -3, 2, 3, -1, -1, 2,
                        3, -1, -1, -1, -1, -1, 3, -12, -1, 3,
                        1, -2, -3, 2, 3, 1, 2, -2, -3, -1, 2,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        1, -2, -3, 2, 3, 1, 2, -2, -3, -1, 2,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        1, -2, -3, 2, 3, 1, 2, -2, -3, -1, 2,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        -1, 2, 3, 3, 1, 2, -2, -3, -1, 2, 3,
                        3, 2, 2, 1, 2, 3, 2, 3, 2, 1, 2}, 10));
    }
}
