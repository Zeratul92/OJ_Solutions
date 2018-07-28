package codeforces;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1011/B'>Planning The Expedition</a>
 */
public class Problem_1011B {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt(); //n people
            int m = in.nextInt(); //m pack
            int type[] = new int[101];
            for (int i = 0; i < m; i++) {
                int ai = in.nextInt();
                type[ai]++;
            }

            Arrays.sort(type);
            int ans = 0;
            for (int day = 1; ; day++) {
                int cnt = 0;
                boolean ok = false;
                for (int i = 100; i >= 0; i--) {
                    if (cnt >= n) {
                        ok = true;
                        break;
                    }
                    if (type[i] < day) {
                        break;
                    }
                    cnt += type[i] / day;
                }
                if (ok) {
                    ans = day;
                } else {
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
