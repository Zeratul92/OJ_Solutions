package leetcode;

/**
 * <a href='https://leetcode.com/problems/reverse-integer/description/'>7. Reverse Integer</a>
 */
public class Algorithm_7_Reverse_Integer {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long ans = 0;
        long k = 0;
        long negative = -1;
        if (x < 0) {
            negative = -1;
            k = (long) x;
            k = -k;
        } else {
            negative = 1;
            k = x;
        }
        while (k > 0) {
            ans *= 10;
            ans += k % 10;
            k /= 10;
        }
        ans += k;
        if ((negative == 1 && ans > Integer.MAX_VALUE) || (negative == -1 && -ans < Integer.MIN_VALUE)) {
            return 0;
        } else {
            return (int) (negative * ans);
        }
    }

    public static void main(String[] args) {
        Algorithm_7_Reverse_Integer solution = new Algorithm_7_Reverse_Integer();
        System.out.println(solution.reverse(12));
        System.out.println(solution.reverse(-231));
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(102));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(Integer.MAX_VALUE / 10));
        System.out.println(solution.reverse(Integer.MAX_VALUE));
        System.out.println(solution.reverse(Integer.MIN_VALUE));

    }
}
