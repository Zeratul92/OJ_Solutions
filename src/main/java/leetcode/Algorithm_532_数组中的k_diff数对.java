package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

 */
public class Algorithm_532_数组中的k_diff数对 {
    public int findPairs(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> notUniqueNumSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                notUniqueNumSet.add(nums[i]);
            }
            numSet.add(nums[i]);
        }
        if (k == 0) {
            return notUniqueNumSet.size();
        }

        int ans = 0;
        for (int num : numSet) {
            if (numSet.contains(num + k)) {
                ans++;
            }
        }


//        int[] numSetArr = new int[numSet.size()];
//        int idx = 0;
//        for (int num : numSet) {
//            numSetArr[idx++] = num;
//        }

//        for (int i = 0; i < numSetArr.length; i++) {
//            int num = numSetArr[i]
//        }

        return ans;
    }

    public static void main(String[] args) {

        Algorithm_532_数组中的k_diff数对 solution = new Algorithm_532_数组中的k_diff数对();
        System.out.println(solution.findPairs(new int[]{3, 1, 4, 1, 5}, 3));
    }
}
