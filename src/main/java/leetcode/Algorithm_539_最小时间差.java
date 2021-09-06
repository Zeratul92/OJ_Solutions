package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 */
public class Algorithm_539_最小时间差 {

    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] minutes = new int[len];
        int idx = 0;
        for (String timePoint : timePoints) {
            minutes[idx++] = Integer.parseInt(timePoint.substring(0, 2)) * 60 + Integer.parseInt(timePoint.substring(3, 5));
        }
        Arrays.sort(minutes);

        int ans = minutes[0] + 24 * 60 - minutes[len - 1];
        for (int i = 0; i < len - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

        Algorithm_539_最小时间差 solution = new Algorithm_539_最小时间差();


        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("02:00");
        list.add("04:01");
        list.add("04:00");
        list.add("04:20");
        list.add("23:58");
        System.out.println(solution.findMinDifference(list));
    }
}
