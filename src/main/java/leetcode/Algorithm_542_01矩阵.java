package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*

 */
public class Algorithm_542_01矩阵 {

    static int dirs = 4;
    static int[] directionsI = new int[]{-1, 0, 1, 0};
    static int[] directionsJ = new int[]{0, -1, 0, 1};

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] ret = new int[row][col];
        boolean[][] isVis = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            ret[i] = new int[col];
            isVis[i] = new boolean[col];
            for (int j = 0; j < col; j++) {
                ret[i][j] = row + col;
                isVis[i][j] = false;
            }
        }

        Queue<Integer> coordinateI = new LinkedList<>();
        Queue<Integer> coordinateJ = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (0 == mat[i][j]) {
                    coordinateI.offer(i);
                    coordinateJ.offer(j);
                    ret[i][j] = 0;
                    isVis[i][j] = true;
                }
            }
        }

        while (!coordinateI.isEmpty() && !coordinateJ.isEmpty()) {
            int i = coordinateI.poll();
            int j = coordinateJ.poll();
            int cnt = ret[i][j];
            for (int dir = 0; dir < dirs; dir++) {
                int ni = i + directionsI[dir];
                int nj = j + directionsJ[dir];
                if (ni < 0 || nj < 0 || ni >= row || nj >= col) {
                    continue;
                }
                if (isVis[ni][nj]) {
                    continue;
                }
                isVis[ni][nj] = true;
                ret[ni][nj] = cnt + 1;
                coordinateI.offer(ni);
                coordinateJ.offer(nj);
            }

        }


        return ret;
    }


    public static void main(String[] args) {

        Algorithm_542_01矩阵 solution = new Algorithm_542_01矩阵();

        int[][] ret = solution.updateMatrix(
                new int[][]{
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 0, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1},
                        {0, 1, 1},
                        {1, 1, 0},
                        {1, 1, 0},
                        {1, 1, 1}});
        for (int i = 0; i < ret.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < ret[i].length; j++) {
                sb.append(ret[i][j]).append('\t');
            }
            System.out.println(sb);
        }

    }
}
