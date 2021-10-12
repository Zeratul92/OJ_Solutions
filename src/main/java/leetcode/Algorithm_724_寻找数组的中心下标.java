package leetcode;

/*

 */
public class Algorithm_724_寻找数组的中心下标 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len];
        int temp = 0;
        for (int i = 0; i < len; i++) {
            temp += nums[i];
            sum[i] = temp;
        }
        if (temp - sum[0] == 0) return 0;
        for (int i = 1; i < len; i++) {
            if (sum[i - 1] == temp - sum[i]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {


        Algorithm_724_寻找数组的中心下标 s = new Algorithm_724_寻找数组的中心下标();
        System.out.println(s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(s.pivotIndex(new int[]{2, 1, -1}));
    }
}
