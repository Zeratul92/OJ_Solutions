package leetcode;

/*

 */
public class Algorithm_922_按奇偶排序数组II {
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        int i = 0, j = 1;
        while (i < len && j < len) {
            if (nums[i] % 2 == 0) {
                ret[i] = nums[i];
                i += 2;
                continue;
            }
            if (nums[j] % 2 != 0) {
                ret[j] = nums[j];
                j += 2;
                continue;
            }
            ret[i] = nums[j];
            ret[j] = nums[i];
            i += 2;
            j += 2;
        }
        while (i < len) {
            ret[i] = nums[i];
            i += 2;
        }
        while (j < len) {
            ret[j] = nums[j];
            j += 2;
        }
        return ret;
    }

    public static void main(String[] args) {


        Algorithm_922_按奇偶排序数组II s = new Algorithm_922_按奇偶排序数组II();
        int[] ret = s.sortArrayByParityII(new int[]{4,1,2,1});
        for (int i : ret) {
            System.out.print(i + "\t");
        }
        System.out.println();

    }
}
