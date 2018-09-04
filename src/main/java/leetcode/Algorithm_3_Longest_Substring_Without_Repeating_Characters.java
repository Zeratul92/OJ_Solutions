package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href='https://leetcode.com/problems/longest-substring-without-repeating-characters/description/'>Longest Substring Without Repeating Characters</a>
 */
public class Algorithm_3_Longest_Substring_Without_Repeating_Characters {
    private static final int MAX_CHAR = 128;

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[MAX_CHAR];

        int begin = 0, end = 0;
        int len = 0;

        while (end < s.length()) {
            if (0 < map[s.charAt(end++)]++) {
                len = Math.max(len, end - begin - 1);

                while (2 > map[s.charAt(begin++)]--) {
                }
            }
        }

        len = Math.max(len, end - begin);
        return len;
    }

    public static void main(String[] args) {
        Algorithm_3_Longest_Substring_Without_Repeating_Characters a3 = new Algorithm_3_Longest_Substring_Without_Repeating_Characters();
        System.out.println(a3.lengthOfLongestSubstring("abc"));
        System.out.println(a3.lengthOfLongestSubstring("aba"));
        System.out.println(a3.lengthOfLongestSubstring("aa"));
        System.out.println(a3.lengthOfLongestSubstring("aabba"));
        System.out.println(a3.lengthOfLongestSubstring("pwwkew"));
    }
}
