package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1009/C'>Annoying Present</a>
 * Mind the precision issue, better use long type to calculate the sum.
 * Created by Zeratul on 2018/7/26.
 */
public class Problem_1009C {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            long n = in.nextInt();
            int m = in.nextInt();
            long minDist = (n * n) / 4;
            long maxDist = n * (n - 1) / 2;
//            System.out.println(minDist + ", " + maxDist);
            long sum = 0;
            for (int i = 0; i < m; i++) {
                long x = in.nextInt();
                long d = in.nextInt();
                if (d >= 0.0) {
                    sum += x * n + d * maxDist;
                } else {
                    sum += x * n + d * minDist;
                }
            }
            System.out.println(String.format("%.7f", (double) sum / (double) n));
        }
    }
}
