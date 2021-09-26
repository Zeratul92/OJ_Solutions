package leetcode;

/**
 *
 */
public class Algorithm_643_子数组最大平均数I {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double sum = 0;
        double[] sums = new double[len];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
        double ans = sums[k - 1];
        for (int i = k; i < len; i++) {
            ans = Math.max(ans, sums[i] - sums[i - k]);
        }
        return ans / k;
    }

    public static void main(String[] args) {
        Algorithm_643_子数组最大平均数I solution = new Algorithm_643_子数组最大平均数I();
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}


