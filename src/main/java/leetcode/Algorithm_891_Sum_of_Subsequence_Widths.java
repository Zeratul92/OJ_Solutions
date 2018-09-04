package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Algorithm_891_Sum_of_Subsequence_Widths {
    private static final int MOD = 1000000007;
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long bit = 1, ret = 0;
        for (int i = 0; i < A.length; i++) {
            ret += A[i] * bit % MOD;
            ret -= A[A.length - 1 - i] * bit % MOD;
            ret %= MOD;
            bit <<= 1;
            bit %= MOD;
        }
        if (ret < 0) {
            ret += MOD;
        }
        return (int) ret;
    }
    public static void main(String[] args) {
        Algorithm_891_Sum_of_Subsequence_Widths solution = new Algorithm_891_Sum_of_Subsequence_Widths();
        
    }
}
