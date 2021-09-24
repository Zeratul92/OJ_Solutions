package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_557_反转字符串中的单词III {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        String[] words = s.split(" ");
        for (String word : words) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(new StringBuffer(word).reverse());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Algorithm_557_反转字符串中的单词III solution = new Algorithm_557_反转字符串中的单词III();

        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
