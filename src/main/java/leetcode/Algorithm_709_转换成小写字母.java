package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_709_转换成小写字母 {

    public String toLowerCase(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Algorithm_709_转换成小写字母 s = new Algorithm_709_转换成小写字母();
        System.out.println(s.toLowerCase(""));
    }
}
