package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1012/C'>http://codeforces.com/problemset/problem/1012/C
 * dp
 * O(n ^ 2) TLE, don't know why
 */
public class Problem_1012C_Hills {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                a[i] = in.nextInt();
            }
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            if (n == 2) {
                System.out.println(a[1] == a[2] ? 1 : 0);
                continue;
            }
            // n >= 3
            // dp[i][j][1] means the minimum result to build j houses on first i hills with j-th house on i-th hill
            // dp[i][j][0] means the minimum result to build j houses on first i hills with j-th house not on i-th hill(on hills before)
            // need not consider the height of hills on i + 1, i + 2, ... when you are acquiring dp[i] result
            int[][][] dp = new int[n + 1][(n + 1) / 2 + 1][2];
            dp[1][1][1] = 0;
            dp[2][1][1] = Math.max(0, 1 + a[1] - a[2]);
            dp[2][1][0] = Math.max(0, 1 + a[2] - a[1]);
            dp[3][2][1] = Math.max(0, 1 + a[2] - Math.min(a[1], a[3]));
            for (int i = 3; i <= n; i++) {
                dp[i][1][1] = Math.max(0, 1 + a[i - 1] - a[i]);
                dp[i][1][0] = Math.min(
                        dp[i - 1][1][1] + Math.max(0, a[i] - a[i - 1] + 1),
                        dp[i - 1][1][0]);
            }

            for (int i = 3; i <= n; i++) {
                for (int j = 2; j <= (i + 1) / 2; j++) {
                    if (j == (i + 1) / 2 && i % 2 == 1) {
                        // put house on hill 1, 3, 5, ..., i - 2, i
                        dp[i][j][1] = dp[i - 2][j - 1][1] +
                                Math.max(0, 1 + a[i - 1] - Math.min(a[i - 2], a[i]));
                        continue;
                    }
                    int x = Math.max(0, 1 + a[i - 1] - Math.min(a[i - 2], a[i]));
                    int y = Math.max(0, 1 + a[i - 1] - a[i]);
                    int z = Math.max(0, 1 + a[i] - a[i - 1]);
                    if (i == j * 2) {
                        dp[i][j][0] = dp[i - 1][j][1] + z;
                    } else {
                        dp[i][j][0] = Math.min(dp[i - 1][j][0], dp[i - 1][j][1] + z);
                    }
                    dp[i][j][1] = Math.min(dp[i - 2][j - 1][1] + x, dp[i - 2][j - 1][0] + y);
                }
            }
            // debug
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= (i + 1) / 2; j++) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("dp[").append(i).append("][").append(j).append("]");
//                    if (i - 1 >= j * 2 - 1)
//                        System.out.println(sb + "[0] = " + dp[i][j][0]);
//                    System.out.println(sb + "[1] = " + dp[i][j][1]);
//                }
//            }

            // get answer
            boolean lineFirst = true;
            for (int j = 1; j <= (n + 1) / 2; j++) {
                if (lineFirst) {
                    lineFirst = false;
                } else {
                    System.out.print(' ');
                }
                if (j * 2 - 1 == n) {
                    System.out.print(dp[n][j][1]);
                } else {
                    System.out.print(Math.min(dp[n][j][0], dp[n][j][1]));
                }
            }
            System.out.println();
        }
    }
}
/*

5
1 2 3 2 2
dp[2][1][0] = 2
dp[2][1][1] = 0
dp[3][1][0] = 2
dp[3][1][1] = 0
dp[4][1][0] = 0
dp[4][1][1] = 2
dp[5][1][0] = 0
dp[5][1][1] = 1
dp[3][2][1] = 2
dp[4][2][0] = 2
dp[4][2][1] = 2
dp[5][2][0] = 2
dp[5][2][1] = 1
dp[5][3][1] = 3

4
5 4 6 2

 */