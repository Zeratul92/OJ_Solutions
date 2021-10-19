package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*

 */
public class Algorithm_867_转置矩阵 {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ret = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                ret[i][j] = matrix[j][i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {


        Algorithm_867_转置矩阵 s = new Algorithm_867_转置矩阵();
        int[][] ret = s.transpose(new int[][]{
                {1,2,1},
                {1,2,3},
                {1,2,2},
                {1,2,1},
                {1,2,3},
        });
        for (int[] ints : ret) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
