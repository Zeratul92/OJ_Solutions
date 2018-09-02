package leetcode;

public class Algorithm_50_Pow_x_n {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1.;
        }
        if (n == 0) {
            return 1.;
        }

        if (n == 0x80000000) {
            return myPow(x * x, n >> 1);
        }
        if (n < 0) {
            return myPow(1. / x, -n);
        }
        if ((n & 1) != 0) {
            return x * myPow(x * x, n >> 1);
        } else {
            return myPow(x * x, n >> 1);
        }
    }

    public static void main(String[] args) {
        Algorithm_50_Pow_x_n s = new Algorithm_50_Pow_x_n();
        System.out.println(s.myPow(2,3));
        System.out.println(s.myPow(1, Integer.MIN_VALUE));
        System.out.println(s.myPow(2, Integer.MIN_VALUE));
    }
}
