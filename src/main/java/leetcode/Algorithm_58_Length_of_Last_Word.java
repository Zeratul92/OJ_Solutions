package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Algorithm_58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        char[] chars = s.toCharArray();
        int idx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                idx = i;
            }
        }
        if (idx == -1) {
            return s.length();
        } else {
            return s.length() - idx - 1;
        }
    }


    public static void main(String[] args) {
        Algorithm_58_Length_of_Last_Word s = new Algorithm_58_Length_of_Last_Word();

    }
}
