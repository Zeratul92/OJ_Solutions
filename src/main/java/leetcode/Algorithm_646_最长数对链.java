package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class Algorithm_646_最长数对链 {

    public int findLongestChain(int[][] pairs) {
        if (null == pairs) return 0;
        int len = pairs.length;
        if (0 == len) return 0;
        if (1 == len) return 1;

        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[1]));

        int right = pairs[0][1];
        int ans = 1;
        for (int i = 1; i < len; i++) {
            if (right < pairs[i][0]) {
                right = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }




    public static void main(String[] args) {

        System.out.println(0);
        System.out.println((0 - 1) % 3);
        System.out.println((0 - 1 - 3) % 3);
        System.out.println((0 - 1 - 4) % 3);
        System.out.println((0 - 1 - 5) % 3);

        Algorithm_646_最长数对链 solution = new Algorithm_646_最长数对链();
        System.out.println(solution.findLongestChain(new int[][]{
                {1, 4},
                {2, 3},
                {5, 11},
                {5, 6},
                {8, 10},
                {3, 11},
                {1, 22}}));
    }
}
