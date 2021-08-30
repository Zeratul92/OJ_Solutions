package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_520_检测大写字母 {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int upperCaseCnt = 0, lowerCaseCnt = 0;
        for (int i = 0; i < len; i++) {
            char letter = word.charAt(i);
            boolean isUpperCase = Character.isUpperCase(letter);
            if (isUpperCase) {
                upperCaseCnt++;
            } else {
                lowerCaseCnt++;
            }
            if (isUpperCase) {
                if (lowerCaseCnt > 0) {
                    return false;
                }
            } else {
                if (upperCaseCnt > 1) {
                    return false;
                }
            }

        }
        return true;
    }


    public static void main(String[] args) {

        Algorithm_520_检测大写字母 solution = new Algorithm_520_检测大写字母();


        System.out.println(solution.detectCapitalUse("abc"));
        System.out.println(solution.detectCapitalUse("abC"));
        System.out.println(solution.detectCapitalUse("aBc"));
        System.out.println(solution.detectCapitalUse("Abc"));
        System.out.println(solution.detectCapitalUse("aBC"));
        System.out.println(solution.detectCapitalUse("AbC"));
        System.out.println(solution.detectCapitalUse("ABc"));
        System.out.println(solution.detectCapitalUse("ABC"));
    }
}
