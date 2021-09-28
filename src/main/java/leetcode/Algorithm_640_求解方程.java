package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class Algorithm_640_求解方程 {
    public int[] getVal(String str) {
        int[] ret = {0, 0};
        int len = str.length();
        int positive = 1;
        int curVal = 0;
        boolean readingNumber = false;
//        System.out.println(str);
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            // 2x+3x-6x=x+2
            if (ch == '+' || ch == '-') {
                if (readingNumber) {
                    ret[1] += curVal * positive;
                }
                readingNumber = false;
                curVal = 0;
                positive = ch == '+' ? 1 : -1;
            } else if (ch == 'x') {
                if (!readingNumber) curVal = 1;
                readingNumber = false;
                ret[0] += curVal * positive;
            } else {
                curVal = curVal * 10 + (ch - '0');
                if (!readingNumber) readingNumber = true;
            }
//            System.out.println(i + ": " + ret[0] + "x + " + ret[1]);
        }
        if (readingNumber) {
            ret[1] += curVal * positive;
//            System.out.println(ret[0] + "x + " + ret[1]);
        }
//        System.out.println();
        return ret;
    }

    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        int[] left = getVal(strs[0]);
        int[] right = getVal(strs[1]);

//        System.out.println(left[0] + "x + " + left[1]);
//        System.out.println(right[0] + "x + " + right[1]);

        left[0] -= right[0];
        left[1] -= right[1];
        if (left[0] == 0 && left[1] == 0) return "Infinite solutions";
        if (left[0] == 0 && left[1] != 0) return "No solution";
        return "x=" + left[1] / -left[0];
    }

    public static void main(String[] args) {
        Algorithm_640_求解方程 solution = new Algorithm_640_求解方程();

        String ret = solution.solveEquation("x+5-3+x=6+x-2");
        System.out.println(ret);
    }
}
