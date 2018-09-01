package leetcode;

public class Algorithm_41_First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            // if 1 <= nums[i] <= nums.length, then put this number into position num[num[i] - 1], to make the array looks like 1, 2, 3, ...
            int n = nums[i];
            if (n <= 0 || n > nums.length) {
                continue;
            }
            if (i == n - 1) {
                continue;
            }
            if (nums[n - 1] == n) {
                continue;
            }
            swap(nums, i, n - 1);
            i--;
        }
        int ans = 1;
        while (ans <= nums.length && nums[ans - 1] == ans) {
            ans++;
        }
        return ans;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    public static void main(String[] args) {
        Algorithm_41_First_Missing_Positive s = new Algorithm_41_First_Missing_Positive();
        System.out.println(s.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(s.firstMissingPositive(new int[]{1,1}));
        System.out.println(s.firstMissingPositive(new int[]{-1, -2, 3, 2}));
        System.out.println(s.firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(s.firstMissingPositive(new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
    }
}
