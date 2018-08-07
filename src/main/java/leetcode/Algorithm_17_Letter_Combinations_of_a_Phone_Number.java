package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href='https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/'>17. Letter Combinations of a Phone Number</a>
 */
public class Algorithm_17_Letter_Combinations_of_a_Phone_Number {
    private static Map<Integer, char[]> letterMap;
    static {
        letterMap = new HashMap<>();
        letterMap.put(2, new char[]{'a', 'b', 'c'});
        letterMap.put(3, new char[]{'d', 'e', 'f'});
        letterMap.put(4, new char[]{'g', 'h', 'i'});
        letterMap.put(5, new char[]{'j', 'k', 'l'});
        letterMap.put(6, new char[]{'m', 'n', 'o'});
        letterMap.put(7, new char[]{'p', 'q', 'r', 's'});
        letterMap.put(8, new char[]{'t', 'u', 'v'});
        letterMap.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    private static List<StringBuilder> getStringBuilder(String s, int idx) {
        List<StringBuilder> ret = new ArrayList<>();
        int digit = s.charAt(idx) - '0';
        if (idx == s.length() - 1) {
            for (char c : letterMap.get(digit)) {
                ret.add(new StringBuilder().append(c));
            }
            return ret;
        }
        List<StringBuilder> temp = getStringBuilder(s, idx + 1);
        for (char c : letterMap.get(digit)) {
            temp.forEach(sb -> ret.add(new StringBuilder().append(c).append(sb)));
        }
        return ret;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        getStringBuilder(digits, 0).forEach(sb -> ans.add(sb.toString()));
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_17_Letter_Combinations_of_a_Phone_Number s = new Algorithm_17_Letter_Combinations_of_a_Phone_Number();
        System.out.println(s.letterCombinations(""));
        System.out.println(s.letterCombinations("3"));
        System.out.println(s.letterCombinations("45"));
        System.out.println(s.letterCombinations("72"));
        System.out.println(s.letterCombinations("79"));
    }
}
