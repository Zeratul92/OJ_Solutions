package leetcode;

/*

 */
public class Algorithm_915_分割数组 {
    public int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] maxArr = new int[len];
        int[] minArr = new int[len];
        int max = nums[0], min = nums[len - 1];
        for (int i = 0; i < len; i++) {
            maxArr[i] = Math.max(nums[i], max);
            max = maxArr[i];
            minArr[len - i - 1] = Math.min(nums[len - i - 1], min);
            min = minArr[len - i - 1];
        }

        for (int i = 0; i < len - 1; i++) {
            if (maxArr[i] <= minArr[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {


        Algorithm_915_分割数组 s = new Algorithm_915_分割数组();
        System.out.println(s.partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(s.partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }
}
