package leetcode;

import java.util.Stack;

public class Algorithm_32_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0, temp = 0;
        for (int i = 0; i < s.length(); i++) {
            // ...(...
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            // ...)...
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (s.charAt(stack.peek()) == ')') {
                stack.push(i);
            } else if (s.charAt(stack.peek()) == '(') {
                stack.pop();
                temp = stack.isEmpty() ? i + 1 : i - stack.peek();
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Algorithm_32_Longest_Valid_Parentheses solution = new Algorithm_32_Longest_Valid_Parentheses();

        System.out.println(solution.longestValidParentheses("(())"));
        System.out.println(solution.longestValidParentheses("(((("));
        System.out.println(solution.longestValidParentheses("()(("));
        System.out.println(solution.longestValidParentheses("))(("));
        System.out.println(solution.longestValidParentheses("(()())))(((((())))()())))"));
    }
}
