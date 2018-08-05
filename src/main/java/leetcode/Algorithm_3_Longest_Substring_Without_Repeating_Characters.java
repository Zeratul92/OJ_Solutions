package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href='https://leetcode.com/problems/longest-substring-without-repeating-characters/description/'>Longest Substring Without Repeating Characters</a>
 */
public class Algorithm_3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int len = s.length();
        Set<Character> charSet = new HashSet<>();
        int ans = 0;
        while (i < len && j < len) {
            char charJ = s.charAt(j);
            if (!charSet.contains(charJ)) {
                charSet.add(charJ);
                ans = Math.max(ans, j - i + 1);
            } else {
                while (s.charAt(i) != charJ) {
                    charSet.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
//            System.out.println((j - i + 1) + "[" + i + ", " + j + "]: " + s.substring(i, j + 1));
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Algorithm_3_Longest_Substring_Without_Repeating_Characters a3 = new Algorithm_3_Longest_Substring_Without_Repeating_Characters();
        System.out.println(a3.lengthOfLongestSubstring("abcdefdaefgheghjkijkfhkikwolsiwabsjfnsbdjs"));
    }
}
