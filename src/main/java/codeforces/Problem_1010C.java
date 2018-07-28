package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1010/C'>Border</a>
 * Number theory.
 * Got to find gcd of k(2 <= k <= 100000) and a group of number a1, a2, ..., an
 */
public class Problem_1010C {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int banknote[] = new int[n];
            for (int i = 0; i < n; i++) {
                banknote[i] = in.nextInt();
            }
            int maxGcd = k;
            for (int i = 0; i < n; i++) {
                maxGcd = gcd(maxGcd, banknote[i]);
                if (maxGcd == 1) {
                    break;
                }
            }
            int cnt = k / maxGcd;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (int i = 0; i < k; i += maxGcd) {
                if (first) {
                    first = false;
                } else {
                    sb.append(' ');
                }
                sb.append(i);
            }
            System.out.println(cnt);
            System.out.println(sb);
        }
    }
}
