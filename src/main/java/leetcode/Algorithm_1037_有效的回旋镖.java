package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*

 */
public class Algorithm_1037_有效的回旋镖 {
    public boolean isBoomerang(int[][] points) {
        if (points[0][0] == points[1][0] && points[0][1] == points[1][1]) return false;
        if (points[0][0] == points[2][0] && points[0][1] == points[2][1]) return false;
        if (points[1][0] == points[2][0] && points[1][1] == points[2][1]) return false;
        return (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]) != (points[1][0] - points[2][0]) * (points[0][1] - points[1][1]);
    }

    public static void main(String[] args) {


        Algorithm_1037_有效的回旋镖 s = new Algorithm_1037_有效的回旋镖();
        System.out.println(s.isBoomerang(new int[][]{
                {1,1},
                {2,3},
                {3,2},
        }));
    }
}
