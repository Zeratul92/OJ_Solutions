package leetcode;

public class Algorithm_74_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                l = mid;
                break;
            } else if (matrix[mid][n - 1] < target) {
              l = mid + 1;
            } else if (target < matrix[mid][0]) {
                r = mid;
            }
        }
        if (target < matrix[l][0] || matrix[l][n - 1] < target) {
            return false;
        }
        int line = l;
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (matrix[line][mid] == target) {
                return true;
            } else if (matrix[line][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (matrix[line][l] == target) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Algorithm_74_Search_a_2D_Matrix s = new Algorithm_74_Search_a_2D_Matrix();
        int[][] mat = {{1}, {3}};
        System.out.println(s.searchMatrix(mat, 1));
        System.out.println(s.searchMatrix(mat, 2));
        System.out.println(s.searchMatrix(mat, 3));
    }
}
