package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1016/A'>http://codeforces.com/problemset/problem/1016/A</a>
 */
public class Problem_1016A_DeathNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int cur = 0;
            StringBuilder sb = new StringBuilder();
            boolean begin = true;
            for (int i = 0; i < n; i++) {
                int sum = cur + a[i];
                int times = sum / m;
                cur = sum % m;
                if (begin) {
                    begin = false;
                } else {
                    sb.append(' ');
                }
                sb.append(times);
            }
            System.out.println(sb);
        }
    }
}
