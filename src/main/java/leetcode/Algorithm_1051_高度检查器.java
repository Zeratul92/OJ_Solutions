package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_1051_高度检查器 {
    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] sorted = new int[len];
        System.arraycopy(heights, 0, sorted, 0, len);
        Arrays.sort(sorted);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (sorted[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_1051_高度检查器 s = new Algorithm_1051_高度检查器();
        System.out.println(s.heightChecker(new int[]{1,1,4,2,1,3}));
    }
}
