package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href="http://codeforces.com/problemset/problem/1/A">Theatre Square</a>
 * Created by Zeratul on 2018/7/25.
 */
public class Problem_1A {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            long x = n / a + (n % a != 0 ? 1 : 0);
            long y = m / a + (m % a != 0 ? 1 : 0);
            System.out.println(x * y);
        }
    }
}
