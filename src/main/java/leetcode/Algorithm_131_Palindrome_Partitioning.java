package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Classic backtracking problem
 */
public class Algorithm_131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        getList(s.toCharArray(), 0, ret, new ArrayList<>(), s);
        return ret;
    }

    private void getList(char[] chars, int idx, List<List<String>> result, List<String> cur, String s) {
        if (idx == chars.length) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = idx; i < chars.length; i++) {
            if (!isPalindrome(chars, idx, i)) {
                continue;
            }
            cur.add(s.substring(idx, i + 1));
            getList(chars, i + 1, result, cur, s);
            cur.remove(cur.size() - 1);
        }
    }

    private boolean isPalindrome(char[] chars, int a, int b) {
        while (a < b) {
            if (chars[a] != chars[b]) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public static void main(String[] args) {

        Algorithm_131_Palindrome_Partitioning solution = new Algorithm_131_Palindrome_Partitioning();

        System.out.println(solution.partition("abcdeedccde"));
    }
}
