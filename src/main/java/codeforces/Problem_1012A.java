package codeforces;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *<a href='http://codeforces.com/problemset/problem/1012/A'> http://codeforces.com/problemset/problem/1012/A
 */
public class Problem_1012A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] a = new int[n * 2];
            for (int i = 0; i < n * 2; i++) {
                a[i] = in.nextInt();
            }
            if (n == 1) {
                System.out.println(0);
                continue;
            }
            Arrays.sort(a);
//            for (int i = 0; i < 2 * n; i++) {
//                System.out.println(i + ": " + a[i]);
//            }
            long x1 = a[0];
            long y1 = a[n];
            long x2 = a[n - 1];
            long y2 = a[2 * n - 1];
            long ans = (x1 - x2) * (y1 - y2);
//            System.out.println(x1 + ", " + y1 + " " + x2 + ", " + y2);
            for (int i = 1; i < n; i++) {
                x1 = a[i];
                y1 = a[0];
                x2 = a[i + n - 1];
                y2 = a[2 * n - 1];
                ans = Math.min(ans, (x1 - x2) * (y1 - y2));
            }
            System.out.println(ans);
        }
    }
}
