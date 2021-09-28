package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class Algorithm_566_重塑矩阵 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) return mat;
        if (m == r && n == c) return mat;
        int[][] ret = new int[r][c];
        int r1 = 0, c1 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ret[r1][c1] = mat[i][j];
                c1++;
                if (c1 == c) {
                    c1 = 0;
                    r1++;
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {

        Algorithm_566_重塑矩阵 solution = new Algorithm_566_重塑矩阵();

        int[][] ret = solution.matrixReshape(
                new int[][]{
                        {1,2,3},
                        {4,5,6}
                }, 3, 2
        );
        for (int[] ints : ret) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
