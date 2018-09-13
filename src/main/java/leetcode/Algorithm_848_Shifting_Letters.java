package leetcode;

public class Algorithm_848_Shifting_Letters {
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        int[] sum = new int[shifts.length];
        int temp = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            temp = (temp + shifts[i]) % 26;
            sum[i] = temp;
        }
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('a' + (chars[i] - 'a' + sum[i]) % 26);
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Algorithm_848_Shifting_Letters s = new Algorithm_848_Shifting_Letters();
        int[] shifts = {3, 5, 9};
        System.out.println(s.shiftingLetters("abc", shifts));
    }
}
