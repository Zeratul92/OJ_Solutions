package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Algorithm_856_Score_of_Parentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> times = new Stack<>();
        int ret = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (times.isEmpty()) {
                    times.push(1);
                } else {
                    times.push(times.peek() << 1);
                }
            } else {
                int time = times.pop();
                if (S.charAt(i - 1) == '(') {
                    ret += time;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Algorithm_856_Score_of_Parentheses s = new Algorithm_856_Score_of_Parentheses();
        System.out.println(s.scoreOfParentheses("(())()"));
        System.out.println(s.scoreOfParentheses("(()((())))"));
    }
}
