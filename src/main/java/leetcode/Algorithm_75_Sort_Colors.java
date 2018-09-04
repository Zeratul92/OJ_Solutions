package leetcode;

public class Algorithm_75_Sort_Colors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int idx0 = 0, idx2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > idx2) {
                break;
            }
            if (0 == nums[i]) {
                if (i == idx0) {
                    idx0++;
                    continue;
                }
                swap(nums, i, idx0);
                idx0++;
                i--;
            } else if (2 == nums[i]) {
                if (i == idx2) {
                    break;
                }
                swap(nums, i, idx2);
                idx2--;
                i--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }


    public static void main(String[] args) {
        Algorithm_75_Sort_Colors s = new Algorithm_75_Sort_Colors();

        int[] nums = {1,0};

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        s.sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
