package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Algorithm_54_Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] vis = new boolean[n][m];
        int curDir = 0;
        int x = 0, y = -1;
        List<Integer> ret = new ArrayList<>();
        while (ret.size() < n * m) {
            int nextX = x + dir[curDir][0];
            int nextY = y + dir[curDir][1];
            if (isIn(nextX, nextY, n, m) && !vis[nextX][nextY]) {
                x = nextX;
                y = nextY;
                vis[x][y] = true;
                ret.add(matrix[x][y]);
            } else {
                curDir = (curDir + 1) % 4;
            }
        }
        return ret;
    }

    private boolean isIn(int i, int j, int n, int m) {
        return 0 <= i && i < n && 0 <= j && j < m;
    }

    public static void main(String[] args) {
        Algorithm_54_Spiral_Matrix s = new Algorithm_54_Spiral_Matrix();
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        System.out.println(s.spiralOrder(mat));
    }
}
