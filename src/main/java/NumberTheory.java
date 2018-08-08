public class NumberTheory {
    private static long[] fac_0_to_20 = {1L,
            1L, 2L, 6L, 24L, 120L,
            720L, 5040L, 40320L, 362880L, 3628800L,
            39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L,
            20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /**
     * P(n, k) = n * (n - 1) * (n - 2) * ...* (n - k + 1) = n! / (n - k)!</br>
     * If k > n, let P(n, k) = 0
     *
     * @param n
     * @param k
     * @return
     */
    private static long permutation(int n, int k) {
        return fac_0_to_20[n] / fac_0_to_20[n - k];
    }

    private static void tesaPermutation(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("P(" + i + ", " + j + ") = " + permutation(i, j));
            }
        }
    }

    private static int[][] getCombination(int n) {
        int[][] ret = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            ret[i][0] = 1;
            ret[i][i] = 1;
        }
        if (n == 0 || n == 1) {
            return ret;
        }
        ret[2][1] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                ret[i][j] = ret[i - 1][j - 1] + ret[i - 1][j];
            }
        }
        return ret;
    }

    private static void testCombination(int n) {
        int[][] p = getCombination(n);
        for (int i = 0; i <= n; i++) {
            System.out.print(i + ":\t");
            for (int j = 0; j <= i; j++) {
                System.out.print(p[i][j] + "\t");
            }
            System.out.println();
        }
    }


    private static long[] getFactorial(int n) {
        long[] ret = new long[n + 1];
        ret[0] = 1;
        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i - 1] * i;
        }
        return ret;
    }


    /**
     * Return n! in long type
     *
     * @param n number
     * @return long result
     */
    private static long factorial(int n) {
        long sum = 1;
        while (n > 0) {
            sum *= n--;
        }
        return sum;
    }

    private static void testFactorial(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(i + "! = " + factorial(i));
        }

        long[] ans = getFactorial(n);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(i + ":\t" + ans[i]);

        }

        for (int i = 1; i < fac_0_to_20.length; i++) {
            System.out.println(fac_0_to_20[i] / fac_0_to_20[i - 1]);
        }
    }


    /**
     * Return getCatalan numbers table of size n + 1, a[0] = 1
     *
     * @param n Size
     * @return An array of getCatalan numbers with size n + 1, a[0] = 1
     */
    private static long[] getCatalan(int n) {
        if (n == 0) {
            return new long[]{1L};
        }
        if (n == 1) {
            return new long[]{1L, 1L};
        }
        if (n == 2) {
            return new long[]{1L, 1L, 2L};
        }
        long[] ret = new long[n + 1];
        ret[0] = 1L;
        ret[1] = 1L;
        ret[2] = 2L;
        for (int i = 3; i <= n; i++) {
            if (ret[i - 1] % (i + 1L) == 0L) {
                ret[i] = ret[i - 1] / (i + 1L) * (4L * i - 2L);
            } else {
                ret[i] = ret[i - 1] * (4L * i - 2L) / (i + 1L);
            }

        }
        return ret;
    }

    public static void main(String[] args) {
//        tesaPermutation(10);


//        testFactorial(21);
        // max_long = 9223372036854775807 < 21!
        // 20!      = 2432902008176640000

//        testCombination(20);

//        long[] catalans = getCatalan(35);
//        for (int i = 0; i < catalans.length; i++) {
//            System.out.println(i + ": " + catalans[i]);
//        }
        // max_long = 9223372036854775807 < cat(35)
        // cat(34)  = 812944042149730764

        //

    }

}
