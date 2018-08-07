import java.util.*;

/**
 * Including some method about prime number
 */
public class PrimeNumber {


    /**
     * get prime number table from 1 to n
     * @param n boundary [1, n]
     * @return An array consists of the prime numbers from 1 to n
     */
    private static int[] getPrimeNumbers(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            isPrime[i] = true;
        }
        for (int factor = 2; factor < n + 1; factor++) {
            if (!isPrime[factor]) {
                continue;
            }
            for (int multiple = factor * 2; 0 < multiple && multiple < n + 1; multiple += factor) {
                isPrime[multiple] = false;
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int prime = 2; prime < n + 1; prime++) {
            if (!isPrime[prime]) {
                continue;
            }
            primeList.add(prime);
        }
        int[] ret = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            ret[i] = primeList.get(i);
        }
        return ret;
    }


    /**
     * use euclidean algorithm to get gcd
     * @param a int
     * @param b int
     * @return gcd
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int euler(int n) {
        int ans = 1;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) {
                n /= i;
                ans *= (i - 1);
                while (n % i == 0) {
                    n /= i;
                    ans *= i;
                }
            }
        if (n > 1)
            ans *= (n - 1);
        return ans;
    }

    /**
     * test Euler function
     */
    private static void test1() {
        int sum = 0;
        for (int i = 2; i < 1000; i++) {
            sum += euler(i);
            if (sum > 100000) {
                System.out.println(i + ", " + euler(i) + ", " + sum);
            }
        }
    }

    /**
     * test prime number table
     */
    private static void test2(int n) {
        System.out.println();
        System.out.println("Prime numbers under " + n);
        Date beginTime = new Date();
        int[] primeNumbers = getPrimeNumbers(n);
        System.out.println(new Date().getTime() - beginTime.getTime());
        StringBuilder sb = new StringBuilder();
        int lastK = 10;
        for (int i = primeNumbers.length - lastK; i < primeNumbers.length; i++) {
            sb.append(primeNumbers[i]).append(", ");
            System.out.println((i + 1) + ": " + primeNumbers[i]);
        }
//        System.out.println(sb);
    }

    public static void main(String[] args) {
        test2(40020);
    }

}
