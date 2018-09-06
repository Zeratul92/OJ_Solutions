package leetcode;

public class Algorithm_861_Score_After_Flipping_Matrix {

    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    A[i][j] ^= 1;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][i] == 1) {
                    cnt++;
                }
            }
            if (cnt >= (m + 1) / 2) {
                continue;
            }

            for (int j = 0; j < m; j++) {
                A[j][i] ^= 1;
            }

        }
        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                ret += 1 << (n - j - 1);
            }
        }

        return ret;
    }

    private void printA(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < a[i].length; j++) {
                sb.append(a[i][j]);
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Algorithm_861_Score_After_Flipping_Matrix s = new Algorithm_861_Score_After_Flipping_Matrix();
        int[][] mat = {
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        System.out.println(s.matrixScore(mat));
    }
}
