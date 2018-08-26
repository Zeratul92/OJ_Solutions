package leetcode;

public class Algorithm_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        int left = l;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int right = nums[l] == target ? l : l - 1;
        return new int[]{left, right};
    }


    public static void main(String[] args) {

        Algorithm_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array solution = new Algorithm_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int[] ans = solution.searchRange(new int[]{1,1,1,1,1,1,1,4}, 2);
        System.out.println(ans[0] + ", " + ans[1]);
    }
}
