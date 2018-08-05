package leetcode;

/**
 * <a href='https://leetcode.com/problems/two-sum/description/'>Two Sum</a>
 */
public class Algorithm_8_String_to_Integer {
    public static boolean isDigit(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }

    public static boolean isSign(char c) {
        if (c == '-' || c == '+') {
            return true;
        }
        return false;
    }


    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        long neg = 1;
        long ans = 0;

        int begin = 0;
        if (str.charAt(0) == '-') {
            begin = 1;
            neg = -1;
        }
        if (str.charAt(0) == '+') {
            begin = 1;
            neg = 1;
        }

        for (int i = begin; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!isDigit(ch)) {
                break;
            }

            ans *= 10;
            ans += ch - '0';
            if (ans > Integer.MAX_VALUE) {
                break;
            }

        }
        ans *= neg;
        if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Algorithm_8_String_to_Integer s = new Algorithm_8_String_to_Integer();
//        System.out.println(s.myAtoi("42"));
//        System.out.println(s.myAtoi(" s  42 asdasdsa"));
//        System.out.println(s.myAtoi("    -42"));
//        System.out.println(s.myAtoi("    91283472332 asdsadsa"));
//        System.out.println(s.myAtoi("4193 with words"));
//        System.out.println(s.myAtoi("+-2"));
//        System.out.println(s.myAtoi("+-2"));
//        System.out.println(s.myAtoi("     +2345"));
//        System.out.println(s.myAtoi("     +2345"));
        System.out.println(s.myAtoi("400 ww"));
        System.out.println(s.myAtoi("   +2147483646"));
        System.out.println(s.myAtoi("   +2147483647"));
        System.out.println(s.myAtoi("   +2147483648"));
        System.out.println(s.myAtoi("   -2147483649"));
        System.out.println(s.myAtoi("   -2147483648"));
        System.out.println(s.myAtoi("   -2147483647"));
        System.out.println(s.myAtoi("   -2147483646"));


    }
}
