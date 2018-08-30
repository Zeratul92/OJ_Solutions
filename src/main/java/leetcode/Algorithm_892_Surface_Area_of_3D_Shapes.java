package leetcode;

public class Algorithm_892_Surface_Area_of_3D_Shapes {
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int[][] mat = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i + 1][j + 1] = grid[i][j];
            }
        }
        if (n == 1) {
            return grid[0][0] * 4 + 2;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans += mat[i][j] > 0 ? 2 : 0;
                ans += mat[i][j] > mat[i][j + 1] ? mat[i][j] - mat[i][j + 1] : 0;
                ans += mat[i][j] > mat[i][j - 1] ? mat[i][j] - mat[i][j - 1] : 0;
                ans += mat[i][j] > mat[i + 1][j] ? mat[i][j] - mat[i + 1][j] : 0;
                ans += mat[i][j] > mat[i - 1][j] ? mat[i][j] - mat[i - 1][j] : 0;
//                System.out.println(i + ", " + j + ": " + ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_892_Surface_Area_of_3D_Shapes solution = new Algorithm_892_Surface_Area_of_3D_Shapes();
        int[][] mat = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int[][] mat = {{2,2,2}, {2,1,2}, {2,2,2}};
//        int[][] mat = {{1,2}, {3,4}};
        System.out.println(solution.surfaceArea(mat));
    }
}
