package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 */
public class Algorithm_496_下一个更大元素I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Stack<Integer> idxStack = new Stack<>();
        int[] idxArr = new int[len2];
        Map<Integer, Integer> idxMap = new HashMap<>();
        Arrays.fill(idxArr, -1);
        for (int i = 0; i < len2; i++) {
            while (!idxStack.isEmpty() && nums2[idxStack.peek()] < nums2[i]) {
                int idx = idxStack.pop();
                idxArr[idx] = i;
                idxMap.put(nums2[idx], nums2[i]);
            }
            idxStack.push(i);
        }

        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ret[i] = idxMap.getOrDefault(nums1[i], -1);
        }


        return ret;
    }


    public static void main(String[] args) {
        Algorithm_496_下一个更大元素I solution = new Algorithm_496_下一个更大元素I();
        int[] ret = solution.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
        for (int i : ret) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
