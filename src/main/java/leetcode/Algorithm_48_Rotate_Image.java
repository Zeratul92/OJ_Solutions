package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm_48_Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                swap(matrix, i, j, j, n - 1 - i);
                swap(matrix, n - 1 - j, i, i, j);
                swap(matrix, n - 1 - i, n - 1 - j, n - 1 - j, i);
            }
        }
    }

    private void swap(int[][] mat, int a, int b, int c, int d) {
        mat[a][b] ^= mat[c][d];
        mat[c][d] ^= mat[a][b];
        mat[a][b] ^= mat[c][d];
    }

    public static void main(String[] args) {
        Algorithm_48_Rotate_Image s = new Algorithm_48_Rotate_Image();

        int[][] mat = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + (j == mat[i].length - 1 ? "\n" : " "));
            }
        }

        s.rotate(mat);
        System.out.println();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + (j == mat[i].length - 1 ? "\n" : " "));
            }
        }

    }
}
