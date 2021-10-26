package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */
public class Algorithm_916_单词子集 {
    private static final int ALPHABET_LEN = 26;

    private int[] str2arr(String word) {
        int[] ret = new int[ALPHABET_LEN];
        Arrays.fill(ret, 0);
        for (int i = 0; i < word.length(); i++)
            ret[word.charAt(i) - 'a']++;
        return ret;
    }

    private boolean aContainB(int[] a, int[] b) {
        for (int i = 0; i < ALPHABET_LEN; i++)
            if (a[i] < b[i])
                return false;
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();

        int[] superB = str2arr("");
        for (String word : words2) {
            int[] arr = str2arr(word);
            for (int i = 0; i < ALPHABET_LEN; i++)
                superB[i] = Math.max(superB[i], arr[i]);
        }

        for (String word : words1)
            if (aContainB(str2arr(word), superB))
                list.add(word);

        return list;
    }

    public static void main(String[] args) {
        Algorithm_916_单词子集 s = new Algorithm_916_单词子集();
        System.out.println(s.wordSubsets(
                new String[]{"amazon","apple","facebook","google","leetcode"},
                new String[]{"e","o"}));
    }
}
