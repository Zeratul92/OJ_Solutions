package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_507_完美数 {
    public boolean checkPerfectNumber(int num) {
        if (num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336) return true;
        return false;
    }


    public static void main(String[] args) {

        int limit = 100000000;
        for (int num = 1; num <= limit; num++) {
            int low = 2, high = (int) Math.sqrt(num);
            int sum = 1;
            for (int i = low; i <= high; i++) {
                if (i > num) break;
                if (num % i != 0) continue;
                sum += i * i == num ? i : i + num / i;
                if (sum > num) break;
            }
            if (sum == num) System.out.println(sum);
        }


        Algorithm_507_完美数 solution = new Algorithm_507_完美数();

        System.out.println(solution.checkPerfectNumber(12));
    }
}
