package leetcode;

import java.util.Arrays;

/*

 */
public class Algorithm_661_图片平滑器 {
    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0;
                int cnt = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        if (0 <= i + x && i + x < row && 0 <= j + y && j + y < col) {
                            sum += img[i + x][j + y];
                            cnt++;
                        }
                    }
                }
                ans[i][j] = sum / cnt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_661_图片平滑器 s = new Algorithm_661_图片平滑器();
        int[][] ret = s.imageSmoother(new int[][]{
                {1,1,1},
                {1,100,1},
                {1,1,1},
        });

        for (int[] ints : ret) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println();

    }
}
