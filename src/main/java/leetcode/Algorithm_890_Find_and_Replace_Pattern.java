package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Algorithm_890_Find_and_Replace_Pattern {
    private static final int MAX_CHAR = 128;

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new LinkedList<>();
        for (String word : words) {
            if (isMatch(word, pattern)) {
                ret.add(word);
            }
        }
        return ret;
    }

    private boolean isMatch(String word, String pattern) {
        int[] a = new int[MAX_CHAR];
        int[] b = new int[MAX_CHAR];
        for (int i = 0; i < word.length(); i++) {
            if (a[word.charAt(i)] != b[pattern.charAt(i)]) {
                return false;
            }
            a[word.charAt(i)] = i + 1;
            b[pattern.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithm_890_Find_and_Replace_Pattern solution = new Algorithm_890_Find_and_Replace_Pattern();
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        System.out.println(solution.findAndReplacePattern(words, "abb"));
    }
}
