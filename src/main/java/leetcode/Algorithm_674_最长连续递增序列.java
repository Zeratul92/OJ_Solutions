package leetcode;

/*

 */
public class Algorithm_674_最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int begin = 0;
        int ans = 1;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                begin = i;
            }
            ans = Math.max(ans, i - begin + 1);
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_674_最长连续递增序列 s = new Algorithm_674_最长连续递增序列();
        System.out.println(s.findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
}
