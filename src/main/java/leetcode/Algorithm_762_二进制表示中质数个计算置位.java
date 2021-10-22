package leetcode;

/*

 */
public class Algorithm_762_二进制表示中质数个计算置位 {
    private final static boolean[] isPrime = {
            false, false, true, true, false, true, false, true, false, false, false,
            true, false, true, false, false, false, true, false, true, false,
            false, false, true, false, false, false, false, false, true, false, true, false};

    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int temp = i;
            int cnt = 0;
            while (temp != 0) {
                if ((temp & 1) == 1) cnt++;
                temp >>= 1;
            }
            if (isPrime[cnt]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_762_二进制表示中质数个计算置位 s = new Algorithm_762_二进制表示中质数个计算置位();
        System.out.println(s.countPrimeSetBits(6, 10));

    }
}
