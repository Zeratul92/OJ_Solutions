package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Algorithm_693_交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        if (n == Integer.MAX_VALUE) return false;
        if (n == 1) return true;
        int last = n % 2;
        for (int i = 1; i < 31; i++) {
            if ((n >> i) <= 0) break;
            int cur = (n >> i) & 1;
            if (cur == last) return false;
            last = cur;
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithm_693_交替位二进制数 solution = new Algorithm_693_交替位二进制数();
        System.out.println(solution.hasAlternatingBits(1));
        System.out.println(solution.hasAlternatingBits(2));
        System.out.println(solution.hasAlternatingBits(3));
        System.out.println(solution.hasAlternatingBits(4));
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(6));
    }
}


