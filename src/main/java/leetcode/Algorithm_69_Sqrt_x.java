package leetcode;

public class Algorithm_69_Sqrt_x {
    private static final int maxSqrt = 46340;
    public int mySqrt(int x) {
        if (0 == x) {
            return 0;
        }
        if (1 == x) {
            return 1;
        }
        if (maxSqrt * maxSqrt <= x) {
            return maxSqrt;
        }
        int l = 1, r = maxSqrt;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public static void main(String[] args) {
        Algorithm_69_Sqrt_x s = new Algorithm_69_Sqrt_x();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(46340 * 46340);
        System.out.println(s.mySqrt(Integer.MAX_VALUE));
        System.out.println(s.mySqrt(Integer.MAX_VALUE - 100000));
        System.out.println(s.mySqrt(Integer.MAX_VALUE - 200000));
    }
}
