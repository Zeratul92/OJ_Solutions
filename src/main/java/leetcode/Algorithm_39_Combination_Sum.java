package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Classic backtracking problem
 */
public class Algorithm_39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> solutions = new ArrayList<>();
        getList(candidates, target, 0, solutions, new ArrayList<>());
        return solutions;
    }

    private void getList(int[] nums, int target, int idx, List<List<Integer>> solutions, List<Integer> cur) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            solutions.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            getList(nums, target - nums[i], i, solutions, cur); // can use the same repeated number
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {

        Algorithm_39_Combination_Sum solution = new Algorithm_39_Combination_Sum();

        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{5, 2, 3}, 8));
    }
}
