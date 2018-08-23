package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Algorithm_885_Spiral_Matrix_III {

    private boolean isIn(int R, int C, int x, int y) {
        return 0 <= x && x <= R - 1 && 0 <= y && y <= C - 1;
    }


    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] ret = new int[R * C][2];
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{r0, c0});
        int x = r0, y = c0;
        int headTo = 0;
        int turn = 0;
        int step = 1;
        while (list.size() < R * C) {
            headTo = turn % 4;
            for (int i = 0; i < step; i++) {
                x += dir[headTo][0];
                y += dir[headTo][1];
                if (isIn(R, C, x, y)) {
                    list.add(new int[]{x, y});
                }
            }
            turn++;
            step = turn / 2 + 1;
        }
        for (int i = 0; i < R * C; i++) {
            ret[i][0] = list.get(i)[0];
            ret[i][1] = list.get(i)[1];
        }

        return ret;
    }

    public static void main(String[] args) {
        Algorithm_885_Spiral_Matrix_III solution = new Algorithm_885_Spiral_Matrix_III();

        int[][] ret = solution.spiralMatrixIII(5, 6, 1, 4);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i][0] + ", " + ret[i][1]);
        }
    }
}
