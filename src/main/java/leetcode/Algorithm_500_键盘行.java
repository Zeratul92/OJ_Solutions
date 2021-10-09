package leetcode;

import java.util.*;

/*

 */
public class Algorithm_500_键盘行 {

    private static Set<Character> setLine1;
    private static Set<Character> setLine2;
    private static Set<Character> setLine3;
    static {
        setLine1 = new HashSet<>();
        setLine2 = new HashSet<>();
        setLine3 = new HashSet<>();

        setLine1.add('q');
        setLine1.add('w');
        setLine1.add('e');
        setLine1.add('r');
        setLine1.add('t');
        setLine1.add('y');
        setLine1.add('u');
        setLine1.add('i');
        setLine1.add('o');
        setLine1.add('p');

        setLine2.add('a');
        setLine2.add('s');
        setLine2.add('d');
        setLine2.add('f');
        setLine2.add('g');
        setLine2.add('h');
        setLine2.add('j');
        setLine2.add('k');
        setLine2.add('l');

        setLine3.add('z');
        setLine3.add('x');
        setLine3.add('c');
        setLine3.add('v');
        setLine3.add('b');
        setLine3.add('n');
        setLine3.add('m');
    }
    public String[] findWords(String[] words) {
        int len = words.length;
        boolean[] isOk = new boolean[len];
        Arrays.fill(isOk, false);
        int ansCnt = 0;
        for (int i = 0; i < len; i++) {
            String word = words[i];
//            System.out.println("testing: " + word);
            int yes1 = 0;
            int yes2 = 0;
            int yes3 = 0;
            boolean ok = true;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (setLine1.contains(c)) yes1 += yes1 == 0 ? 1 : 0;
                if (setLine2.contains(c)) yes2 += yes2 == 0 ? 1 : 0;
                if (setLine3.contains(c)) yes3 += yes3 == 0 ? 1 : 0;
                if (yes1 + yes2 + yes3 > 1) {
                    ok = false;
//                    System.out.print("idx = " + i + ": " + c + " hehe");
                    break;
                }
            }
//            System.out.println(ok ? "good" : "hehe");
            if (ok) {
                isOk[i] = true;
                ansCnt++;
            }
        }
        String[] ret = new String[ansCnt];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (isOk[i]) ret[idx++] = words[i];
        }
        return ret;
    }

    public static void main(String[] args) {

        Algorithm_500_键盘行 solution = new Algorithm_500_键盘行();

//        String[] ret = solution.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        String[] ret = solution.findWords(new String[]{"asdfghjkla","qwertyuiopq","zxcvbnzzm","asdfghjkla","qwertyuiopq","zxcvbnzzm"});
        for (String s : ret) {
            System.out.println(s);
        }
        System.out.println();
    }
}
