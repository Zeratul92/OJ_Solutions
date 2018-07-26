package codeforces.problem_1009B;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * <a href='http://codeforces.com/problemset/problem/1009/B'>Minimum Ternary String</a>
 * '1' can be put in any place because '1' can swap to both '0' and '2', therefore no '1' should be put right to any '2's(no '2211')
 * Then consider that '2' and '0' can't be swapped, so the relative positions of them should remain the same.(02102 --> 01202)
 *
 * Hence we have the following steps.
 * Step1: get all '0' and '2' with their relative orders unchanged, leave out all '1'(need to count the number of '1')
 * Step2: put all '1' just before the first '2' you got
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while (in.hasNext()) {
            String s = in.nextLine();
            StringBuilder ans = new StringBuilder(s.length());
            StringBuilder zeroAndTwo = new StringBuilder(s.length());
            int sumOfOne = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    sumOfOne++;
                } else {
                    zeroAndTwo.append(s.charAt(i));
                }
            }
            boolean got2 = false;
            for (int i = 0; i < zeroAndTwo.length(); i++) {
                if (!got2 && zeroAndTwo.charAt(i) == '2') {
                    got2 = true;
                    for (int j = 0; j < sumOfOne; j++) {
                        ans.append('1');
                    }
                    sumOfOne = 0;
                }
                ans.append(zeroAndTwo.charAt(i));
            }
            if (sumOfOne > 0) {
                for (int i = 0; i < sumOfOne; i++) {
                    ans.append('1');
                }
            }

            System.out.println(ans.toString());
        }
    }
}
