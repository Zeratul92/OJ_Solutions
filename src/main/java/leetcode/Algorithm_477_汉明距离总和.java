package leetcode;

/*

 */
public class Algorithm_477_汉明距离总和 {
    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int ans = 0;
        while (maxNum > 0) {
            int cnt1 = 0;
            int cnt0 = 0;
            for (int i = 0; i < len; i++) {
                if ((nums[i] & 1) == 1) {
                    cnt1++;
                } else {
                    cnt0++;
                }
                nums[i] >>= 1;
            }
            ans += cnt1 * cnt0;
            maxNum >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_477_汉明距离总和 s = new Algorithm_477_汉明距离总和();
        System.out.println(s.totalHammingDistance(new int[]{4,14,2}));
        System.out.println(s.totalHammingDistance(new int[]{4,14,4}));


    }
}
