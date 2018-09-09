package leetcode;

public class Algorithm_902_Numbers_At_Most_N_Given_Digit_Set {

    public int atMostNGivenDigitSet(String[] D, int N) {
        String num = N + "";
        int len = num.length();
        int ret = 0; // result
        int cnt = 1; // count helper
        int[] count = new int[len];
        count[len - 1] = 1;
        for (int i = 0; i < len - 1; i++) {
            cnt *= D.length;
            count[len - i - 2] = cnt;
            ret += cnt;
        }
        // if len == 4
        // count would be 64, 16, 4, 1

        // digitCnt[i] means how many digits in D that is smaller or equal to i
        int[] digitCnt = new int[11];
        boolean[] hasDigit = new boolean[10];
        for (String s : D) {
            int d = Integer.valueOf(s);
            hasDigit[d] = true;
            for (int i = d; i < digitCnt.length; i++) {
                digitCnt[i]++;
            }
        }

//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        for (int i = 0; i < digitCnt.length; i++) {
//            sb1.append(i).append(" ");
//            sb2.append(digitCnt[i]).append(" ");
//        }
//        System.out.println(sb1);
//        System.out.println(sb2);

        for (int i = 0; i < len; i++) {
            int digit = num.charAt(i) - '0';
            if (hasDigit[digit]) {
                ret += (digitCnt[digit] - 1) * count[i];
            } else {
                ret += digitCnt[digit] * count[i];
                break;
            }
            if (i == len - 1) {
                ret++;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        Algorithm_902_Numbers_At_Most_N_Given_Digit_Set s = new Algorithm_902_Numbers_At_Most_N_Given_Digit_Set();
        String[] D = {"1", "3", "5", "7"};
        System.out.println(s.atMostNGivenDigitSet(D, 175));
    }
}
