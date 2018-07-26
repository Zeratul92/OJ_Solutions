package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1009/A'>Game Shopping</a>
 */
public class Problem_1009A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int cost[] = new int[n];
            int bill[] = new int[m];
            for (int i = 0; i < n; i++)
                cost[i] = in.nextInt();
            for (int i = 0; i < m; i++)
                bill[i] = in.nextInt();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (ans >= m)
                    break;
                if (bill[ans] >= cost[i])
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
