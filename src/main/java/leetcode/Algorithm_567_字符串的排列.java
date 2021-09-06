package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_567_字符串的排列 {

    public boolean isSameArr(int[] a1, int[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        int[] table = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < len1; i++) {
            char tableChar = s1.charAt(i);
            table[tableChar - 'a']++;
            char wordChar = s2.charAt(i);
            window[wordChar - 'a']++;
        }

        if (isSameArr(table, window)) return true;

        for (int i = 1; i + len1 <= len2; i++) {
            char oldChar = s2.charAt(i - 1);
            char newChar = s2.charAt(i + len1 - 1);
            window[oldChar - 'a']--;
            window[newChar - 'a']++;

            if (isSameArr(table, window)) return true;
        }

//        System.out.println("----------------check----------------");
//        System.out.println("table");
//        out(table);
//        System.out.println("window");
//        out(window);
//        System.out.println("----------------check end----------------");
        return false;
    }


    public void out(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.print((char) ('a' + i));
                System.out.print(": " + arr[i]);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Algorithm_567_字符串的排列 solution = new Algorithm_567_字符串的排列();

        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }
}
