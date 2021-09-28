package leetcode;

/**
 *
 */
public class Algorithm_680_验证回文字符串Ⅱ {

    public boolean isPalindrome(String s) {
//        System.out.println(s);
        int len = s.length();
        if (s.length() == 1) return true;
        int head = 0, tail = len - 1;
        while (head < tail) {
            if (s.charAt(head) == s.charAt(tail)) {
                head++;
                tail--;
                continue;
            }
            return false;
        }
        return true;
    }


    public boolean validPalindrome(String s) {
        int len = s.length();
        if (s.length() == 1) return true;
        int head = 0, tail = len - 1;
        while (head < tail) {
            if (s.charAt(head) == s.charAt(tail)) {
                head++;
                tail--;
                continue;
            }
            if (head + 1 == tail) return true;
            return isPalindrome(s.substring(head, tail)) || isPalindrome(s.substring(head + 1, tail + 1));
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithm_680_验证回文字符串Ⅱ solution = new Algorithm_680_验证回文字符串Ⅱ();

        System.out.println(solution.validPalindrome("adbcba"));
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("1233212"));
    }
}
