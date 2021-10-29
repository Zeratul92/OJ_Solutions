package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*

 */
public class Algorithm_1030_距离顺序排列矩阵单元格 {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows * cols][2];
        int idx = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                ans[idx++] = new int[]{i, j};
        Arrays.sort(ans, Comparator.comparingInt(o -> (Math.abs(o[0] - rCenter) + Math.abs(o[1] - cCenter))));
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_1030_距离顺序排列矩阵单元格 s = new Algorithm_1030_距离顺序排列矩阵单元格();
        int[][] ans = s.allCellsDistOrder(4, 4, 2, 2);
    }
}
