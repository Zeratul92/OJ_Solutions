package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1016/D'> http://codeforces.com/problemset/problem/1016/D </a>
 * Simple xor problem
 */
public class Problem_1016D_VasyaAndTheMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            int aXor = 0;
            int bXor = 0;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                aXor ^= a[i];
            }
            for (int i = 0; i < m; i++) {
                b[i] = in.nextInt();
                bXor ^= b[i];
            }
            if (aXor != bXor) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                for (int i = 0; i < n - 1; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < m; j++) {
                        if (j < m - 1) {
                            sb.append(0).append(' ');
                        } else {
                            sb.append(a[i]);
                        }
                    }
                    System.out.println(sb);
                }
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    if (j < m - 1) {
                        sb.append(b[j]).append(' ');
                    } else {
                        sb.append(aXor ^ b[m - 1] ^ a[n - 1]);
                    }
                }
                System.out.println(sb);
            }

        }
    }
}
