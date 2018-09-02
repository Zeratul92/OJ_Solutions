package leetcode;

public class Algorithm_63_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        boolean obs = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                obs = true;
            }
            dp[i][0] = obs ? 0 : 1;
        }
        obs = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                obs = true;
            }
            dp[0][i] = obs ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Algorithm_63_Unique_Paths_II s = new Algorithm_63_Unique_Paths_II();
    }
}
