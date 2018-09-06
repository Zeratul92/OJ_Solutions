package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Algorithm_859_Buddy_Strings {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int n = A.length();
        boolean dup = false;
        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                list.add(i);
            }
            if (list.size() > 2) {
                return false;
            }
            if (!dup) {
                if (!set.add(A.charAt(i))) {
                    dup = true;
                }
            }
        }
        if (list.size() == 2) {
            return A.charAt(list.get(0)) == B.charAt(list.get(1)) && A.charAt(list.get(1)) == B.charAt(list.get(0));
        }
        if (list.size() == 1) {
            return false;
        }
        return dup;
    }

    public static void main(String[] args) {
        Algorithm_859_Buddy_Strings s = new Algorithm_859_Buddy_Strings();

    }
}
