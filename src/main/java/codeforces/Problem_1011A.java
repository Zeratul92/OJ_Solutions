package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1011/A'>Stages</a>
 */
public class Problem_1011A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            boolean alpha[] = new boolean[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                alpha[ch - 'a'] = true;
            }
            int cnt = 0;
            int sum = 0;
            int last = -2;
            for (int i = 0; i < 26; i++) {
                if (cnt == k) {
                    break;
                }
                if (!alpha[i]) {
                    continue;
                }
                if (i - last < 2) {
                    continue;
                }
                sum += i + 1;
                cnt ++;
                last = i;
            }
            if (cnt < k) {
                System.out.println(-1);
            } else {
                System.out.println(sum);
            }
        }
    }
}
