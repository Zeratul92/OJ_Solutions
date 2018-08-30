package leetcode;

public class Algorithm_66_Plus_One {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i - 1]++;
                digits[i] = 0;
            }
        }
        if (digits[0] == 10) {
            digits[0] = 0;
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ret[i + 1] = digits[i];
            }
            return ret;
        } else {
            return digits;
        }
    }
}
