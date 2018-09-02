package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Algorithm_56_Merge_Intervals {

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> ret = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return ret;
        }
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        int x = intervals.get(0).start;
        int y = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (y >= interval.start) {
                y = Math.max(y, interval.end);
            } else {
                ret.add(new Interval(x, y));
                x = interval.start;
                y = interval.end;
            }
        }
        ret.add(new Interval(x, y));

        return ret;
    }

    public static void main(String[] args) {
        Algorithm_56_Merge_Intervals s = new Algorithm_56_Merge_Intervals();
    }
}
