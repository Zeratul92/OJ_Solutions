package leetcode;

import java.util.ArrayList;
import java.util.List;

/*

 */
public class Algorithm_1018_可被5整除的二进制前缀 {

    public List<Boolean> prefixesDivBy5(int[] nums) {
        int len = nums.length;
        List<Boolean> list = new ArrayList<>(len);
        int cur = 0;
        for (int num : nums) {
            cur <<= 1;
            cur += num;
            cur %= 5;
            list.add(cur % 5 == 0);
        }
        return list;
    }

    public static void main(String[] args) {
        Algorithm_1018_可被5整除的二进制前缀 s = new Algorithm_1018_可被5整除的二进制前缀();
//        System.out.println(s.prefixesDivBy5(new int[]{1,0,0,1,1,0,0,0,0,0,0,1,1,1,0,1,0,1}));
//        System.out.println(s.prefixesDivBy5(new int[]{0,1,1}));
        System.out.println(s.prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}));
    }
}
