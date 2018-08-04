package codeforces;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * <a href='http://codeforces.com/problemset/problem/1016/B'>http://codeforces.com/problemset/problem/1016/B
 */
public class Problem_1016B_SegmentOccurrences {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            in.nextLine();
            String s = in.nextLine();
            String t = in.nextLine();

            int[] ans = new int[n + 1];
            int sum = 0;
            if (n >= m) {
                for (int i = 0; i < n - m + 1; i++) {
                    boolean ok = true;
                    for (int j = 0; j < m; j++) {
                        if (s.charAt(i + j) == t.charAt(j)) {
                            continue;
                        }
                        ok = false;
                    }

                    if (ok) {
                        sum++;
                    }
                    ans[i + 1] = sum;
                }
            }



            for (int i = 0; i < q; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                if (r - l + 1 < m) {
                    System.out.println(0);
                    continue;
                }

                System.out.println(ans[r - m + 1] - ans[l - 1]);
            }
        }
    }
}
