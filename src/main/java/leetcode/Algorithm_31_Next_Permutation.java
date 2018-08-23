package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href='https://leetcode.com/problems/next-permutation/description/'>31. Next Permutation</a>
 */
public class Algorithm_31_Next_Permutation {
    private void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            swap(nums, i, j - 1);
        }

        int k = nums.length - 1;
        i++;
        while (i < k) {
            swap(nums, i, k);
            i++;
            k--;
        }
    }


    public static void main(String[] args) {

        Algorithm_31_Next_Permutation solution = new Algorithm_31_Next_Permutation();
        int[] a = {1, 2, 3, 4, 5};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "" +  (i == a.length - 1 ? '\n' : ' '));
        }
        solution.nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "" +  (i == a.length - 1 ? '\n' : ' '));
        }
        solution.nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "" +  (i == a.length - 1 ? '\n' : ' '));
        }
        solution.nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "" +  (i == a.length - 1 ? '\n' : ' '));
        }
        solution.nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "" +  (i == a.length - 1 ? '\n' : ' '));
        }
        solution.nextPermutation(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "" +  (i == a.length - 1 ? '\n' : ' '));
        }
    }
}
