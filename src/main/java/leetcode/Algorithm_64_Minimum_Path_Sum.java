package leetcode;

public class Algorithm_64_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        int tempSum = 0;
        for (int i = 0; i < m; i++) {
            tempSum += grid[i][0];
            dp[i][0] = tempSum;
        }
        tempSum = 0;
        for (int i = 0; i < n; i++) {
            tempSum += grid[0][i];
            dp[0][i] = tempSum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + (j == n - 1 ? "\n" : " "));
//            }
//        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Algorithm_64_Minimum_Path_Sum s = new Algorithm_64_Minimum_Path_Sum();
        System.out.println(s.minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}
