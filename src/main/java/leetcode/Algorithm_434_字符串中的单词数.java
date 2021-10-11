package leetcode;

/*

 */
public class Algorithm_434_字符串中的单词数 {
    public int countSegments(String s) {
        if (s.length() == 0) return 0;
        String[] words = s.split(" ");
        int ans = 0;
        for (String word : words) {
            if (word.length() > 0) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_434_字符串中的单词数 s = new Algorithm_434_字符串中的单词数();
        System.out.println(s.countSegments(", , , ,        a, eaefa"));
        System.out.println(s.countSegments(""));


    }
}
