package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * not finished
 */
public class Algorithm_600_不含连续1的非负整数 {





    public int findIntegers(int n) {
        int bitCnt = 31;
        int[] power2 = new int[bitCnt];
        for (int i = 0; i < bitCnt; i++) {
            power2[i] = 1 << i;
        }

        List<Integer> okSet = new ArrayList<>();
        List<Integer> notOkSet = new ArrayList<>();

        for (int num = 1; num <= 100; num++) {
            boolean flag = false;
            for (int digit = 0; digit < bitCnt - 1; digit++) {
                if ((num & power2[digit]) > 0 && (num & power2[digit + 1]) > 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                okSet.add(num);
            } else {
                notOkSet.add(num);
            }
        }

        System.out.println(okSet.size());
        System.out.println(okSet);

        System.out.println(notOkSet.size());
        System.out.println(notOkSet);


        return 0;
    }

    public static void main(String[] args) {

        Algorithm_600_不含连续1的非负整数 solution = new Algorithm_600_不含连续1的非负整数();


        System.out.println(solution.findIntegers(1));
    }
}
