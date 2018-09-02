package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Algorithm_898_Orderly_Queue {
    public String orderlyQueue(String S, int K) {
        if (K >= 2) {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
        String ans = S;
        for (int i = 0; i < S.length(); i++) {
            String temp = S.substring(i) + S.substring(0, i);
            if (temp.compareTo(ans) < 0) {
                ans = temp;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Algorithm_898_Orderly_Queue s = new Algorithm_898_Orderly_Queue();
        System.out.println(s.orderlyQueue("cba", 1));
        System.out.println(s.orderlyQueue("acacb", 2));
    }
}
