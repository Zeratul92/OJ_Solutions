package codeforces;

import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1013/B'> http://codeforces.com/problemset/problem/1013/B </a>
 */
public class Problem_1013B {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            HashMap<Integer, Integer> mapA = new HashMap<>();
            HashMap<Integer, Integer> mapB = new HashMap<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (!mapA.containsKey(a[i])) {
                    mapA.put(a[i], 0);
                }
                mapA.put(a[i], mapA.get(a[i]) + 1);
                b[i] = a[i] & x;
                if (!mapB.containsKey(b[i])) {
                    mapB.put(b[i], 0);
                }
                mapB.put(b[i], mapB.get(b[i]) + 1);
            }
            boolean ok = false;
            int ans = 2;
            for (int i = 0; i < n; i++) {
                if (mapA.get(a[i]) > 1) {
                    ok = true;
                    ans = Math.min(ans, 0);
                    break;
                }
                if (a[i] != b[i]) {
                    if (mapA.containsKey(b[i])) {
                        ok = true;
                        ans = Math.min(ans, 1);
                        continue;
                    }
                    if (mapB.containsKey(a[i])) {
                        ok = true;
                        ans = Math.min(ans, 1);
                        continue;
                    }
                    if (mapB.get(b[i]) > 1) {
                        ok = true;
                        ans = Math.min(ans, 2);
                    }
                } else {
                    if (mapB.get(b[i]) > 1) {
                        ok = true;
                        ans = Math.min(ans, 1);
                    }
                }
            }
            if (ok) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }

        }
    }
}
