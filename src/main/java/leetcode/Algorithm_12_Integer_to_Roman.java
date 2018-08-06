package leetcode;

/**
 * <a href='https://leetcode.com/problems/integer-to-roman/description/'>12. Integer to Roman</a>
 */
public class Algorithm_12_Integer_to_Roman {
    private static String[] CHARS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CHARS.length; i++) {
            while (num >= VALUES[i]) {
                sb.append(CHARS[i]);
                num -= VALUES[i];
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Algorithm_12_Integer_to_Roman a = new Algorithm_12_Integer_to_Roman();
        System.out.println(a.intToRoman(1));
        System.out.println(a.intToRoman(2));
        System.out.println(a.intToRoman(3));
        System.out.println(a.intToRoman(4));
        System.out.println(a.intToRoman(5));
        System.out.println(a.intToRoman(6));
        System.out.println(a.intToRoman(11));
        System.out.println(a.intToRoman(94));
        System.out.println(a.intToRoman(95));
        System.out.println(a.intToRoman(99));
        System.out.println(a.intToRoman(100));
        System.out.println(a.intToRoman(101));
    }
}
