package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm_884_Uncommon_Words_from_Two_Sentences {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int idx = 0;
        String word;
        while (true) {
            int space = A.indexOf(' ', idx);
            if (space == -1) {
                break;
            }
            word = A.substring(idx, space);
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
            idx = space + 1;
        }
        word = A.substring(idx);
        if (!map.containsKey(word)) {
            map.put(word, 0);
        }
        map.put(word, map.get(word) + 1);

        idx = 0;
        while (true) {
            int space = B.indexOf(' ', idx);
            if (space == -1) {
                break;
            }
            word = B.substring(idx, space);
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
            idx = space + 1;
        }
        word = B.substring(idx);
        if (!map.containsKey(word)) {
            map.put(word, 0);
        }
        map.put(word, map.get(word) + 1);
        for (String s : map.keySet()) {
            if (map.get(s) > 1) {
                continue;
            }
            list.add(s);
        }
        String[] ret = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

//        System.out.println(list);

        return ret;
    }

    public static void main(String[] args) {
        Algorithm_884_Uncommon_Words_from_Two_Sentences solution = new Algorithm_884_Uncommon_Words_from_Two_Sentences();
        String[] ret = solution.uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println(ret[0]);
    }
}
