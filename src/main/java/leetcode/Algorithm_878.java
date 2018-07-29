package leetcode;

/**
 * <a href='https://leetcode.com/problems/nth-magical-number/description/'>Nth Magical Number</a>
 * Number theory, using Euclidean Algorithm to get greatest common divisor
 */
public class Algorithm_878 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int nthMagicalNumber(int N, int A, int B) {
        long n = (long) N;
        int gcd = gcd(A, B);
        int x = B / gcd;
        int y = A / gcd;
        int lcm = x * A;
        int cnt = x + y - 1;
        int aMultiple = A, bMultiple = B;
        int[] opt = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            if (aMultiple > bMultiple) {
                opt[i] = bMultiple;
                bMultiple += B;
            } else {
                opt[i] = aMultiple;
                aMultiple += A;
            }
        }
//        for (int i = 0; i < cnt; i++) {
//            System.out.println(i + ": " + opt[i]);
//        }
        int more = N % cnt;
        int times = N / cnt;
        long MOD = 1000000007L;
        long ans = ((long) times) * ((long) lcm) % MOD;
        if (more > 0) {
            ans = (ans + (long) opt[more - 1]) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Algorithm_878 solution = new Algorithm_878();
        System.out.println(solution.nthMagicalNumber(9, 6, 5));
        System.out.println(solution.nthMagicalNumber(10, 6, 5));
        System.out.println(solution.nthMagicalNumber(11, 6, 5));
        System.out.println(solution.nthMagicalNumber(12, 6, 5));
        System.out.println(solution.nthMagicalNumber(13, 6, 5));
    }
}
