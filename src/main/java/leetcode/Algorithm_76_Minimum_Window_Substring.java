package leetcode;

public class Algorithm_76_Minimum_Window_Substring {
    private static final int MAX_CHAR = 128;

    public String minWindow(String s, String t) {
        int[] map = new int[MAX_CHAR];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int start = 0, end = 0, size = 0;
        int minLen = s.length() + 1, idx = 0;
        while (end < s.length()) {

            if (0 < map[s.charAt(end++)]--) {
                size++;
            }

            while (size == t.length()) {
                if (end - start < minLen) {
                    minLen = end - start;
                    idx = start;
                }

                map[s.charAt(start)]++;
                if (0 < map[s.charAt(start)]) {
                    size--;
                }
                start++;
            }
        }

        return minLen == s.length() + 1 ? "" : s.substring(idx, idx + minLen);
    }

    public static void main(String[] args) {
        Algorithm_76_Minimum_Window_Substring s = new Algorithm_76_Minimum_Window_Substring();
        System.out.println(s.minWindow("hssahssa", "ha"));
        System.out.println(s.minWindow("abc", "ha"));
        System.out.println(s.minWindow("abch", "ha"));
        System.out.println(s.minWindow("abchabc", "ha"));
        System.out.println(s.minWindow("hhhhhaaaa", "ha"));
    }
}
