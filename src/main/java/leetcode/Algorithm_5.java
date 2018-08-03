package leetcode;

/**
 * <a href='https://leetcode.com/problems/longest-palindromic-substring/description/'>5. Longest Palindromic Substring</a>
 */
public class Algorithm_5 {

    public static String getHelpString(String s, char $) {
        StringBuilder sb = new StringBuilder();
        sb.append($);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append($);
        }
        String str = sb.toString();
        return str;
    }

    /**
     * Using Manacher algorithm
     * @param s A String
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int ans = 0;
        int maxPos = 0;

        char sep = '$';
        String str = getHelpString(s, sep);
        int[] len = new int[str.length()];

        len[0] = 1;
        int maxRight = 0;
        int mid = 0;
        for (int i = 1; i < str.length(); i++) {
            if (maxRight > i) {
                len[i] = Math.min(len[2 * mid - i], maxRight - i);
            } else {
                len[i] = 1;
            }
            while (0 <= i - len[i] && i + len[i] < str.length() &&
                    str.charAt(i + len[i]) == str.charAt(i - len[i])) {
                len[i]++;
            }
            if (len[i] + i > maxRight) {
                maxRight = len[i] + i;
                mid = i;
            }
            // tag the maximum data
            if (len[i] > ans) {
                ans = len[i];
                maxPos = i;
            }
        }

//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(i);
//        }
//        System.out.println();
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(len[i]);
//        }
//        System.out.println();
//        System.out.println(str);
//        System.out.println(ans + ", midPos = " + maxPos);

        StringBuilder ansStr = new StringBuilder();
        for (int i = maxPos - ans + 1; i <= maxPos + ans - 1; i++) {
            if (str.charAt(i) != sep) {
                ansStr.append(str.charAt(i));
            }
        }

        return ansStr.toString();
    }

    public static void main(String[] args) {
        Algorithm_5 al = new Algorithm_5();
        System.out.println(al.longestPalindrome("hehe"));
    }
}
