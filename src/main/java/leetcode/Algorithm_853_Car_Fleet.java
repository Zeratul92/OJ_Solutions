package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Algorithm_853_Car_Fleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n <= 1) {
            return n;
        }
        double[][] data = new double[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = target - position[i];
            data[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(data, Comparator.comparingDouble(value -> value[0]));

        int ans = 0;

        double curTime = 0;
        for (double[] d : data) {
//            System.out.println(d[0] + ", " + d[1]);
            if (d[1] > curTime) {
                curTime = d[1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_853_Car_Fleet s = new Algorithm_853_Car_Fleet();
        System.out.println(s.carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3}));
        System.out.println(s.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }
}
