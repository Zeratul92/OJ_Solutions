package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * According to Euler's totient function table, we have φ(2) + φ(3) + ... + φ(573) = 100023 > 10 ^ 5,
 * so brute force with Euclidean algorithm to calculate the GCD
 * <a href='http://codeforces.com/problemset/problem/1009/D'>Relatively Prime Graph</a>
 * Created by Zeratul on 2018/7/26.
 */
public class Problem_1009D {
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
            int m = in.nextInt();
            if (m < n - 1) {
                System.out.println("Impossible");
                continue;
            }
            int u[] = new int[m];
            int v[] = new int[m];
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (cnt == m) {
                        break;
                    }
                    if (gcd(i, j) == 1) {
                        u[cnt] = i;
                        v[cnt] = j;
                        cnt++;
                    }
                }
            }
            if (cnt == m) {
                System.out.println("Possible");
                for (int i = 0; i < cnt; i++) {
                    System.out.println(u[i] + " " + v[i]);
                }
            } else {
                System.out.println("Impossible");
            }


        }
    }
}
