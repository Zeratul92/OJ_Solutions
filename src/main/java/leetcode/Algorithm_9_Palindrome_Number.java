package leetcode;

/**
 * <a href='https://leetcode.com/problems/palindrome-number/description/'>9. Palindrome Number</a>
 */
public class Algorithm_9_Palindrome_Number {
    public boolean isPalindrome(int x) {
        String s = x + "";
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithm_9_Palindrome_Number s = new Algorithm_9_Palindrome_Number();
        System.out.println(s.isPalindrome(123));
        System.out.println(s.isPalindrome(323));
        System.out.println(s.isPalindrome(-1));
    }
}
