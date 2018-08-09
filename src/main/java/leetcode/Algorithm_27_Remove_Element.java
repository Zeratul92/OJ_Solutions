package leetcode;

/**
 * <a href='https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/'>26. Remove Duplicates from Sorted Array</a>
 */
public class Algorithm_27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[len++] = nums[i];
        }
        return len;
    }

    public static void main(String[] args) {
        Algorithm_27_Remove_Element solution = new Algorithm_27_Remove_Element();
        int[] a = {2,1,2,2,4,5};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();


        int len = solution.removeElement(a, 2);
        System.out.println(len);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
