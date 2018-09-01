package leetcode;

public class Algorithm_43_Multiply_Strings {
    public String multiply(String num1, String num2) {
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int posA = i + j;
                int posB = i + j + 1;
                ans[posB] += temp;
                ans[posA] += ans[posB] / 10;
                ans[posB] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : ans) {
            if (sb.length() == 0 && digit == 0) {
                continue;
            }
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Algorithm_43_Multiply_Strings s = new Algorithm_43_Multiply_Strings();
        System.out.println(s.multiply("12", "12"));
    }
}
