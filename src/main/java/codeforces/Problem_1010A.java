package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1010/A'>Fly</a>
 * Binary Search, mind the condition that the rocket crash.
 */
public class Problem_1010A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt(); // planet cnt
            double m = in.nextInt(); // cargo weight
            double a[] = new double[n]; // take off
            double b[] = new double[n]; // land on
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            boolean ok = false;
            double ans = -1;
            double left = 0.0;
            double right = 1000000001;
            while (right - left >= 0.000001) {
                double mid = (right + left) / 2.0;
                double curWeight = mid + m - (mid + m) / a[0];
                if (curWeight < m) {
//                    System.out.println("die! mid = " + String.format("%.7f", mid));
                    left = mid;
                    continue;
                }
                boolean die = false;
                for (int i = 1; i < n; i++) {
                    curWeight = curWeight - curWeight / b[i]; // land on i-th planet
                    if (curWeight < m) {
                        die = true;
                        break;
                    }
                    curWeight = curWeight - curWeight / a[i]; // take off from i-th planet
                    if (curWeight < m) {
                        die = true;
                        break;
                    }
                }
                if (die) {
//                    System.out.println("die! mid = " + String.format("%.7f", mid));
                    left = mid;
                    continue;
                }
                // return to earth
                curWeight = curWeight - curWeight / b[0];
                if (curWeight < m) {
//                    System.out.println("die! mid = " + String.format("%.7f", mid));
                    left = mid;
                    continue;
                }
                // ok trip
//                System.out.println("ok! mid = " + String.format("%.7f", mid));
                ok = true;
                ans = mid;
                right = mid;
            }


            if (ok) {
                System.out.println(String.format("%.7f", ans));
            } else {
                System.out.println(-1);
            }
        }
    }
}
