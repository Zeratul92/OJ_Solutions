package leetcode;

/**
 * <a href='https://leetcode.com/problems/roman-to-integer/description/'>13. Roman to Integer</a>
 */
public class Algorithm_13_Roman_to_Integer {
    private static String[] CHARS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int romanToInt(String s) {
        int ans = 0;
        String cur = s;
        for (int i = 0; i < CHARS.length; i++) {
            while (cur.length() > 0 && cur.startsWith(CHARS[i])) {
                ans += VALUES[i];
                cur = cur.substring(CHARS[i].length());
            }
            if (cur.length() == 0) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Algorithm_13_Roman_to_Integer a = new Algorithm_13_Roman_to_Integer();
        System.out.println(a.romanToInt("I"));
        System.out.println(a.romanToInt("II"));
        System.out.println(a.romanToInt("III"));
        System.out.println(a.romanToInt("IV"));
        System.out.println(a.romanToInt("V"));
        System.out.println(a.romanToInt("VI"));
        System.out.println(a.romanToInt("XI"));
        System.out.println(a.romanToInt("XCIV"));
        System.out.println(a.romanToInt("XCV"));
        System.out.println(a.romanToInt("XCIX"));
        System.out.println(a.romanToInt("C"));
        System.out.println(a.romanToInt("CI"));
    }
}
