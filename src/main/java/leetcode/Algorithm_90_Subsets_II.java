package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Classic backtracking problem
 */
public class Algorithm_90_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        Arrays.sort(nums);
        getList(nums, 0, solutions, new ArrayList<>());
        return solutions;
    }

    private void getList(int[] nums, int idx, List<List<Integer>> result, List<Integer> cur) {
        result.add(new ArrayList<>(cur));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            getList(nums, i + 1, result, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {

        Algorithm_90_Subsets_II solution = new Algorithm_90_Subsets_II();

        System.out.println(solution.subsetsWithDup(new int[]{2,1,2}));
    }
}
