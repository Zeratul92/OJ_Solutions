package leetcode;

import java.util.*;

/**
 *
 */
public class Algorithm_696_计数二进制子串 {

    public int countBinarySubstrings(String s) {
        int ans = 0;
        int len = s.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; ) {
            char c = s.charAt(i);
            int tempCnt = 0;
            int idx = i;
            while (idx < len && s.charAt(idx) == c) {
                tempCnt++;
                idx++;
            }
            list.add(tempCnt);
            i = idx;
        }
//        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            ans += Math.min(list.get(i), list.get(i + 1));
        }

        return ans;
    }
    public static void main(String[] args) {
        Algorithm_696_计数二进制子串 solution = new Algorithm_696_计数二进制子串();
        System.out.println(solution.countBinarySubstrings("00110011"));
    }
}


