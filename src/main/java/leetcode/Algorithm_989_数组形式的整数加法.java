package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

 */
public class Algorithm_989_数组形式的整数加法 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new LinkedList<>();
        int len = num.length;
        int idx = len - 1;
        int carry = 0;
        while (k > 0 || idx >= 0) {
            int ori = idx >= 0 ? num[idx] : 0;
            idx--;
            int cur = ori + k % 10 + carry;
            k /= 10;
            if (cur >= 10) {
                cur -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.add(0, cur);
        }
        if (carry == 1) ans.add(0, 1);
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_989_数组形式的整数加法 s = new Algorithm_989_数组形式的整数加法();
        System.out.println(s.addToArrayForm(new int[]{9,9}, 1));
        System.out.println(s.addToArrayForm(new int[]{9,9}, 2));
        System.out.println(s.addToArrayForm(new int[]{2,1,5}, 806));
    }
}
