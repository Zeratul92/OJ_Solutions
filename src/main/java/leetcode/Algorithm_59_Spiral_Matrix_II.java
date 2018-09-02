package leetcode;

public class Algorithm_59_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] vis = new boolean[n][n];
        int[][] ret = new int[n][n];
        int curDir = 0;
        int x = 0, y = -1;
        int idx = 0;
        while (idx < n * n) {
            int nextX = x + dir[curDir][0];
            int nextY = y + dir[curDir][1];
            if (isIn(nextX, nextY, n) && !vis[nextX][nextY]) {
                x = nextX;
                y = nextY;
                vis[x][y] = true;
                ret[x][y] = ++idx;
            } else {
                curDir = (curDir + 1) % 4;
            }
        }

        return ret;
    }

    private boolean isIn(int i, int j, int n) {
        return 0 <= i && i < n && 0 <= j && j < n;
    }

    public static void main(String[] args) {
        Algorithm_59_Spiral_Matrix_II s = new Algorithm_59_Spiral_Matrix_II();
        int n = 1;
        int[][] mat = s.generateMatrix(n);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + (j == n - 1 ? "\n" : " "));
            }
        }
    }
}
