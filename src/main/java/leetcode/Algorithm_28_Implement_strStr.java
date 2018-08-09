package leetcode;

/**
 * <a href='https://leetcode.com/problems/implement-strstr/description/'>28. Implement strStr()</a>
 */
public class Algorithm_28_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle);
    }
}
