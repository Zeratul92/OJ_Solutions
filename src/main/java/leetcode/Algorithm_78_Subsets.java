package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Classic backtracking problem
 */
public class Algorithm_78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        getList(nums, 0, ret, new ArrayList<>());
        return ret;
    }

    private void getList(int[] nums, int idx, List<List<Integer>> result, List<Integer> cur) {
        result.add(new ArrayList<>(cur));
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            getList(nums, i + 1, result, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {

        Algorithm_78_Subsets solution = new Algorithm_78_Subsets();

        System.out.println(solution.subsets(new int[]{1,2}));
    }
}
