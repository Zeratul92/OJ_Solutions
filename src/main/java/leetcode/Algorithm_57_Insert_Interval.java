package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Algorithm_57_Insert_Interval {

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

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        int x = intervals.get(0).start;
        int y = intervals.get(0).end;
        List<Interval> ret = new ArrayList<>();
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
        Algorithm_57_Insert_Interval s = new Algorithm_57_Insert_Interval();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));
        List<Interval> ret = s.insert(list, new Interval(4, 8));
        for (Interval interval : ret) {
            System.out.println(interval.start + ", " + interval.end);
        }
    }
}
