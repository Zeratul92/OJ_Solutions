package codeforces;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1013/A'> http://codeforces.com/problemset/problem/1013/A </a>
 */
public class Problem_1013A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            int n = in.nextInt();
            int sumX = 0, sumY = 0;
            for (int i = 0; i < n; i++) {
                sumX += in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                sumY += in.nextInt();
            }
            if (sumX >= sumY) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
