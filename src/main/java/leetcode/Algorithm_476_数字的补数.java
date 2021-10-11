package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_476_数字的补数 {
    public int findComplement(int num) {
        int temp = 0;
        int cnt = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                temp += 1 << cnt;
            }
            num >>= 1;
            cnt++;
        }
        return temp;
    }


    public static void main(String[] args) {

        Algorithm_476_数字的补数 solution = new Algorithm_476_数字的补数();

        System.out.println(solution.findComplement(1));
        System.out.println(solution.findComplement(2));
        System.out.println(solution.findComplement(3));
        System.out.println(solution.findComplement(4));
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(6));
    }
}
