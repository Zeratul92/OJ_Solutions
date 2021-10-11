package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_498_对角线遍历 {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] ret = new int[row * col];

        int idx = 0;
        int cnt = 0;
        while (idx < row * col) {
            if (cnt % 2 == 0) {
                for (int i = Math.min(cnt, row - 1); 0 <= i; i--) {
                    int j = cnt - i;
                    if (j >= col) break;
                    ret[idx++] = mat[i][j];
                }
            } else {
                for (int j = Math.min(cnt, col - 1); 0 <= j; j--) {
                    int i = cnt - j;
                    if (i >= row) break;
                    ret[idx++] = mat[i][j];
                }
            }
            cnt++;
        }

        return ret;
    }


    public static void main(String[] args) {

        Algorithm_498_对角线遍历 solution = new Algorithm_498_对角线遍历();

        int[] ret = solution.findDiagonalOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12},
                {13,14,15},
        });

        for (int s : ret) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println();
    }
}
