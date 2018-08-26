package leetcode;

public class Algorithm_33_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int min = nums[0], minIdx = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < min) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[r] < nums[0]) {
            minIdx = r;
            min = nums[r];
        }
        l = minIdx;
        r = minIdx + n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            int num = nums[mid % n];
            if (num == target) {
                return mid % n;
            } else if (num < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[l % n] != target) {
            return -1;
        } else {
            return l % n;
        }
    }


    public static void main(String[] args) {

        Algorithm_33_Search_in_Rotated_Sorted_Array solution = new Algorithm_33_Search_in_Rotated_Sorted_Array();
        System.out.println(solution.search(new int[]{7, 9, 12, 14, 4, 6}, 12));
        System.out.println(solution.search(new int[]{6,1,2,3,4}, 3));
        System.out.println(solution.search(new int[]{0, 1}, 0));
        System.out.println(solution.search(new int[]{5,6,7,8,9,1}, 2));
        System.out.println(solution.search(new int[]{88,2,5,6,87}, 3));
    }
}
