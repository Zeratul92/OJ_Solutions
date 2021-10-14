package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*

 */
public class Algorithm_953_验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;

        int alphaLen = 26;
        int[] orderMap = new int[alphaLen];
        for (int i = 0; i < alphaLen; i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < len - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int wordLen = Math.max(word1.length(), word2.length());
            for (int wordIdx = 0; wordIdx < wordLen; wordIdx++) {
                int order1 = wordIdx < word1.length() ? orderMap[word1.charAt(wordIdx) - 'a'] : -1;
                int order2 = wordIdx < word2.length() ? orderMap[word2.charAt(wordIdx) - 'a'] : -1;
                if (order2 > order1) {
                    break;
                }
                if (order1 > order2) {
//                    System.out.println(word1 + " idx: " + wordIdx);
//                    System.out.println(word2 + " idx: " + wordIdx);
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {


        Algorithm_953_验证外星语词典 s = new Algorithm_953_验证外星语词典();
        System.out.println(s.isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(s.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(s.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
