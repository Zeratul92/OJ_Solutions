package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

 */
public class Algorithm_492_构造矩形 {

    public int[] constructRectangle(int area) {
        int sq = (int) Math.sqrt(area);
        while (area % sq != 0) {
            sq--;
        }
        return new int[]{area / sq, sq};
    }
    public static void main(String[] args) {

        Algorithm_492_构造矩形 solution = new Algorithm_492_构造矩形();

        int[] ret = solution.constructRectangle(12);
        for (int s : ret) {
            System.out.println(s);
        }
        System.out.println();
    }
}
