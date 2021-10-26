package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

 */
public class Algorithm_766_托普利茨矩阵 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
        return true;
    }

    public static void main(String[] args) {


        Algorithm_766_托普利茨矩阵 s = new Algorithm_766_托普利茨矩阵();
        System.out.println(s.isToeplitzMatrix(new int[][]{

        }));

    }
}
