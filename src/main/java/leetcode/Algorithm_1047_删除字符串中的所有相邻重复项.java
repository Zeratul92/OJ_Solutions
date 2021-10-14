package leetcode;

import java.util.Arrays;
import java.util.Stack;

/*

 */
public class Algorithm_1047_删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        int len = s.length();
        char[] chars = new char[len];
        int idx = 0, cur = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (cur == 0) {
                chars[cur++] = c;
                continue;
            }
            if (chars[cur - 1] == c) {
                cur--;
            } else {
                chars[cur++] = c;
            }
        }
        return String.copyValueOf(chars, 0, cur);
    }

    public static void main(String[] args) {


        Algorithm_1047_删除字符串中的所有相邻重复项 s = new Algorithm_1047_删除字符串中的所有相邻重复项();
        System.out.println(s.removeDuplicates("abbaca"));
    }
}
