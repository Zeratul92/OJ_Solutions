package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_598_范围求和II {

    public int maxCount(int m, int n, int[][] ops) {
        int minA = m;
        int minB = n;
        for (int i = 0; i < ops.length; i++) {
            int a = ops[i][0];
            int b = ops[i][1];
            minA = Math.min(minA, a);
            minB = Math.min(minB, b);
        }
        return minA * minB;
    }


    public static void main(String[] args) {

        Algorithm_598_范围求和II solution = new Algorithm_598_范围求和II();

        System.out.println(solution.maxCount(
                3, 3,
                new int[][]{}));
    }
}
