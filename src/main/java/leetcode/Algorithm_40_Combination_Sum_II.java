package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Classic backtracking problem
 */
public class Algorithm_40_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            getList(nums, target - nums[i], i + 1, solutions, cur); // Each number may only be used once
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {

        Algorithm_40_Combination_Sum_II solution = new Algorithm_40_Combination_Sum_II();

        System.out.println(solution.combinationSum2(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum2(new int[]{5, 2, 3}, 8));
        System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
