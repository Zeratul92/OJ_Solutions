package leetcode;

public class Algorithm_35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l] < target) {
            return l + 1;
        } else {
            return l;
        }
    }

    public static void main(String[] args) {

        Algorithm_35_Search_Insert_Position solution = new Algorithm_35_Search_Insert_Position();
        System.out.println(solution.searchInsert(new int[]{1,3,4,5}, 2));
        System.out.println(solution.searchInsert(new int[]{1,2}, 2));
        System.out.println(solution.searchInsert(new int[]{1,2,3}, 2));
    }
}
