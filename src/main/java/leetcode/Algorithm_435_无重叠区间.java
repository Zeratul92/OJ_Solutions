package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class Algorithm_435_无重叠区间 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (null == intervals) return 0;
        int len = intervals.length;
        if (0 == len || 1 == len) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int maxAns = 1;
        int right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                maxAns++;
            }
        }
        return len - maxAns;
    }

    public static void main(String[] args) {

        Algorithm_435_无重叠区间 solution = new Algorithm_435_无重叠区间();

        System.out.println(solution.eraseOverlapIntervals(
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
