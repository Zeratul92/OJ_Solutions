package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Algorithm_893_Groups_of_Special_Equivalent_Strings {

    public int numSpecialEquivGroups(String[] A) {
        boolean[] flag = new boolean[A.length];
        Set<Map<Integer, Map<Character, Integer>>> ansSet = new HashSet<>();

        for (int idx = 0; idx < A.length; idx++) {
            char[] chars = A[idx].toCharArray();
            Map<Character, Integer> charMap1 = new HashMap<>();
            for (int i = 0; i < chars.length; i += 2) {
                if (!charMap1.containsKey(chars[i])) {
                    charMap1.put(chars[i], 0);
                }
                charMap1.put(chars[i], charMap1.get(chars[i]) + 1);
            }
            Map<Character, Integer> charMap2 = new HashMap<>();
            for (int i = 1; i < chars.length; i += 2) {
                if (!charMap2.containsKey(chars[i])) {
                    charMap2.put(chars[i], 0);
                }
                charMap2.put(chars[i], charMap2.get(chars[i]) + 1);
            }
            Map<Integer, Map<Character, Integer>> map = new HashMap<>();
            map.put(1, charMap1);
            map.put(2, charMap2);
            ansSet.add(map);
        }
        return ansSet.size();
    }

    public static void main(String[] args) {
        Algorithm_893_Groups_of_Special_Equivalent_Strings solution = new Algorithm_893_Groups_of_Special_Equivalent_Strings();
        System.out.println(solution.numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
        System.out.println(solution.numSpecialEquivGroups(new String[]{"abcd","cdab","adcb","cbad"}));
    }
}
