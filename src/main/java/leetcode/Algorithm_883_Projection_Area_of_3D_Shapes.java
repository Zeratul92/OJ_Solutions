package leetcode;

/**
 * https://leetcode.com/problems/projection-area-of-3d-shapes/description/
 */
public class Algorithm_883_Projection_Area_of_3D_Shapes {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ans++;
            }
        }

        for (int i = 0; i < row; i++) {
            int maxHeight = 0;
            for (int j = 0; j < col; j++) {
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
            ans += maxHeight;
        }

        for (int j = 0; j < col; j++) {
            int maxHeight = 0;
            for (int i = 0; i < row; i++) {
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
            ans += maxHeight;
        }

        return ans;
    }

    public static void main(String[] args) {
        Algorithm_883_Projection_Area_of_3D_Shapes p = new Algorithm_883_Projection_Area_of_3D_Shapes();
        System.out.println(p.projectionArea(new int[][]{
                new int[]{1,1,1},
                new int[]{1,0,1},
                new int[]{1,1,1}
        }));
    }
}
