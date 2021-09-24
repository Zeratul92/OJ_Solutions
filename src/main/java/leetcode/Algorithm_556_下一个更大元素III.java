package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_556_下一个更大元素III {

    public void swapDigit(int idx1, int idx2, int[] digits) {
        int number = digits[idx1];
        digits[idx1] = digits[idx2];
        digits[idx2] = number;
    }

    public int nextGreaterElement(int n) {
        String nStr = Integer.toString(n);
        int len = nStr.length();
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = nStr.charAt(i) - '0';
        }

        boolean flag = false;
        int changeIdx = 0;
        for (int i = len - 1; i >= 1; i--) {
            int right = digits[i];
            int left = digits[i - 1];
            if (right > left) {
                flag = true;
                changeIdx = i - 1;
                break;
            }
        }
//        System.out.println("number: " + n);
//        System.out.println("[" + changeIdx + "]: " + digits[changeIdx]);

        if (flag) {
            int changeIdxDigit = digits[changeIdx];
            int minLargerDigit = 10;
            int minLargerIdx = 0;
            for (int i = changeIdx + 1; i < len; i++) {
                if (digits[i] > changeIdxDigit) {
                    if (digits[i] < minLargerDigit) {
                        minLargerDigit = digits[i];
                        minLargerIdx = i;
                    }
                }
            }

            swapDigit(changeIdx, minLargerIdx, digits);

            int[] tempDigits = new int[len - changeIdx - 1];
            for (int i = changeIdx + 1; i < len; i++) {
                tempDigits[i - changeIdx - 1] = digits[i];
            }
            Arrays.sort(tempDigits);
            for (int i = changeIdx + 1; i < len; i++) {
                digits[i] = tempDigits[i - changeIdx - 1];
            }

            long ans = 0L;
            long base = 1L;
            for (int i = 0; i < len; i++) {
                ans += (long) digits[len - i - 1] * base;
                base *= 10L;
            }
//            System.out.println("ans = " + ans);
            if (ans > Integer.MAX_VALUE) {
                return -1;
            }
            return (int) ans;
        }
        return -1;
    }

    public static void main(String[] args) {

        Algorithm_556_下一个更大元素III solution = new Algorithm_556_下一个更大元素III();

        System.out.println("2147483476 " + solution.nextGreaterElement(2147483476));

        System.out.println(Integer.MAX_VALUE + ": " + solution.nextGreaterElement(Integer.MAX_VALUE));
    }
}
