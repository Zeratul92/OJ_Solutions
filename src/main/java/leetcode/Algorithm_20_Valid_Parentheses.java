package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href='https://leetcode.com/problems/valid-parentheses/description/'>20. Valid Parentheses</a>
 */
public class Algorithm_20_Valid_Parentheses {
    private static Map<Character, Integer> parenToInt = new HashMap<>();
    static {
        // each pair's sum equal 7
        parenToInt.put('(', 1);
        parenToInt.put(')', 6);
        parenToInt.put('[', 2);
        parenToInt.put(']', 5);
        parenToInt.put('{', 3);
        parenToInt.put('}', 4);
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int idx = parenToInt.get(s.charAt(i));
            if (idx <= 3) {
                stack.push(idx);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() + idx != 7) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Algorithm_20_Valid_Parentheses a = new Algorithm_20_Valid_Parentheses();
        System.out.println(a.isValid("((()))"));
        System.out.println(a.isValid("()))"));
        System.out.println(a.isValid("([)]"));
        System.out.println(a.isValid("{[]}"));
    }
}
