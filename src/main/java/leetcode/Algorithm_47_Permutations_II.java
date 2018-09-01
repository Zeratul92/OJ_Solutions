package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Classic backtracking problem
 */
public class Algorithm_47_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solutions = new ArrayList<>();
        getList(nums, 0, solutions, new ArrayList<>(), new boolean[nums.length]);
        return solutions;
    }

    private void getList(int[] nums, int idx, List<List<Integer>> result, List<Integer> cur, boolean[] vis) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            cur.add(nums[i]);
            vis[i] = true;
            getList(nums, idx + 1, result, cur, vis);
            cur.remove(cur.size() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {

        Algorithm_47_Permutations_II solution = new Algorithm_47_Permutations_II();

        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
}
