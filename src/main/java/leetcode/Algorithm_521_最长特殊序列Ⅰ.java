package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */
public class Algorithm_521_最长特殊序列Ⅰ {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {

        Algorithm_521_最长特殊序列Ⅰ solution = new Algorithm_521_最长特殊序列Ⅰ();


        System.out.println(solution.findLUSlength("list", ""));
    }
}
