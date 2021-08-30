package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Classic backtracking problem
 */
public class Algorithm_77_组合 {

    public void dfs(int left, int right, int cnt, int idx, int[] temp, List<List<Integer>> ret) {
        for (int num = left; num <= right - cnt + 1; num++) {
            temp[idx] = num;
            if (cnt > 1) {
                dfs(num + 1, right, cnt - 1, idx + 1, temp, ret);
            } else {
                List<Integer> list = new ArrayList<>(idx + 1);
                for (int i = 0; i <= idx; i++) {
                    list.add(temp[i]);
                }
                ret.add(list);
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(1, n, k, 0, new int[k], ret);
        return ret;
    }

    public static void main(String[] args) {

        Algorithm_77_组合 solution = new Algorithm_77_组合();
        List<List<Integer>> ret = solution.combine(10, 3);

        ret.forEach(System.out::println);
    }
}
