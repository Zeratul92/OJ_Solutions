package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*

 */
public class Algorithm_977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        Integer[] temp = new Integer[nums.length];
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, Comparator.comparingInt(Math::abs));
        for (int i = 0; i < nums.length; i++) {
            ret[i] = temp[i] * temp[i];
        }

        return ret;
    }

    public static void main(String[] args) {


        Algorithm_977_有序数组的平方 s = new Algorithm_977_有序数组的平方();

    }
}
