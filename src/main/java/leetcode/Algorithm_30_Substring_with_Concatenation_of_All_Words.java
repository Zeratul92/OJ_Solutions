package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href='https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/'>30. Substring with Concatenation of All Words</a>
 */
public class Algorithm_30_Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        if (words == null || words.length == 0 || words[0] == null) {
            return ret;
        }
        int size = words[0].length();
        if (size == 0) {
            return ret;
        }
        int sizeAll = size * words.length;

        if (s == null || s.length() < sizeAll) {
            return ret;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 0);
            }
            wordMap.put(word, wordMap.get(word) + 1);
        }

        for (int i = 0; i < size; i++) {
            if (s.length() - i < sizeAll) {
                break;
            }

            int start = i;
            Map<String, Integer> tempMap = new HashMap<>();
            for (int t = 0; t < words.length; t++) {
                String tempStr = s.substring(start + t * size, start + (t + 1) * size);
                if (!tempMap.containsKey(tempStr)) {
                    tempMap.put(tempStr, 0);
                }
                tempMap.put(tempStr, tempMap.get(tempStr) + 1);
            }
            if (tempMap.equals(wordMap)) {
                ret.add(start);
            }
            while (start + sizeAll + size <= s.length()) {
                String pre = s.substring(start, start + size);
                if (tempMap.get(pre) == 1) {
                    tempMap.remove(pre);
                } else {
                    tempMap.put(pre, tempMap.get(pre) - 1);
                }
                String next = s.substring(start + sizeAll, start + sizeAll + size);
                if (!tempMap.containsKey(next)) {
                    tempMap.put(next, 0);
                }
                tempMap.put(next, tempMap.get(next) + 1);
                start += size;
                if (tempMap.equals(wordMap)) {
                    ret.add(start);
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map1.put("hehe", 1);
        map2.put("hehe", 1);
        map2.put("haha", 0);
        System.out.println(map1.equals(map2));

        Algorithm_30_Substring_with_Concatenation_of_All_Words solution = new Algorithm_30_Substring_with_Concatenation_of_All_Words();
        String[] words = {"bar", "foo"};
        System.out.println(solution.findSubstring("barbarbarbarfoofoofoo", words));
    }
}
