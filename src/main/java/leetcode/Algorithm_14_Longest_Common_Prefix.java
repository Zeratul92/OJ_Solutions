package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href='https://leetcode.com/problems/longest-common-prefix/description/'>14. Longest Common Prefix</a>
 */
public class Algorithm_14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            Set<Character> charSet = new HashSet<>();
            for (int i = 0; i < strs.length; i++) {
                if (pos >= strs[i].length()) {
                    return sb.toString();
                }
                if (charSet.add(strs[i].charAt(pos)) && charSet.size() > 1) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(pos));
            pos++;
        }
    }

    public static void main(String[] args) {
        Algorithm_14_Longest_Common_Prefix s = new Algorithm_14_Longest_Common_Prefix();
        System.out.println(s.longestCommonPrefix(new String[]{
                "skr",
                "skrskr",
                "skriskr",
                "sr"
        }));
        System.out.println(s.longestCommonPrefix(new String[]{
                "1234",
                "12345",
                "12567",
                "1"
        }));
    }
}
