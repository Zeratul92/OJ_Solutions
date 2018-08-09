package leetcode;

/**
 * <a href='https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/'>26. Remove Duplicates from Sorted Array</a>
 */
public class Algorithm_26_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[len - 1]) {
                continue;
            }
            nums[len] = nums[i];
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        Algorithm_26_Remove_Duplicates_from_Sorted_Array solution = new Algorithm_26_Remove_Duplicates_from_Sorted_Array();
        int[] a = {0,0,0,1,2,3,4,4,4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();


        int len = solution.removeDuplicates(a);
        System.out.println(len);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
