package leetcode;

import java.util.Arrays;

public class Algorithm_869_Reordered_Power_of_2 {
    private static int[][] powOf2 = new int[31][10];

    static {
        int pow = 1;
        for (int i = 0; i < powOf2.length; i++) {
            String s = pow + "";
            for (char c : s.toCharArray()) {
                powOf2[i][c - '0']++;
            }
            pow <<= 1;
        }
    }


    public boolean reorderedPowerOf2(int N) {
        char[] chars = (N + "").toCharArray();
        int[] a = new int[10];
        for (char c : chars) {
            a[c - '0']++;
        }
        for (int[] ints : powOf2) {
            if (isSame(ints, a)) {
                return true;
            }
        }

        return false;
    }

    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithm_869_Reordered_Power_of_2 s = new Algorithm_869_Reordered_Power_of_2();
        System.out.println(s.reorderedPowerOf2(1));
        System.out.println(s.reorderedPowerOf2(2));
        System.out.println(s.reorderedPowerOf2(3));
        System.out.println(s.reorderedPowerOf2(4));
        System.out.println(s.reorderedPowerOf2(5));
    }
}
