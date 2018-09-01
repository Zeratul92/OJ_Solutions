package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Classic backtracking problem
 */
public class Algorithm_46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
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
            if (vis[i]) {
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

        Algorithm_46_Permutations solution = new Algorithm_46_Permutations();

        System.out.println(solution.permute(new int[]{1, 2, 3, 4}));
    }
}
