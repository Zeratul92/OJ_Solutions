package leetcode;

/**
 * <a href='https://leetcode.com/problems/divide-two-integers/description/'>29. Divide Two Integers</a>
 */
public class Algorithm_29_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean neg = (dividend < 0) ^ (divisor < 0);
        long a = dividend;
        a = a < 0 ? -a : a;
        long b = divisor;
        b = b < 0 ? -b : b;
        long ans = recursiveDivide(a, b);
        System.out.println("ans = " + ans);
        if (ans > Integer.MAX_VALUE) {
            return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else {
            return neg ? (int) -ans : (int) ans;
        }
    }

    private long recursiveDivide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0L;
        }

        long sum = divisor;
        long mul = 1L;
        while (sum + sum < dividend) {
            sum += sum;
            mul += mul;
        }
        System.out.println("mul = " + mul + ", sum = " + sum);

        return mul + recursiveDivide(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        Algorithm_29_Divide_Two_Integers solution = new Algorithm_29_Divide_Two_Integers();
        System.out.println(solution.divide(Integer.MIN_VALUE, 1));
        System.out.println(solution.divide(Integer.MIN_VALUE, -1));
    }
}
