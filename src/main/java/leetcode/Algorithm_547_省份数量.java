package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*

 */
public class Algorithm_547_省份数量 {

    int[] p;

    public int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int x, int y) {
        p[find(x)] = find(y);
    }


    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        p = new int[len];

        for (int i = 0; i < len; i++) {
            p[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                    for (int k = 0; k < len; k++) {
                        System.out.print(k + ": " + p[k] + "\t");
                    }
                    System.out.println();

                }

            }
        }



        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (i == p[i]) {
                ans++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {

        Algorithm_547_省份数量 solution = new Algorithm_547_省份数量();
        System.out.println(solution.findCircleNum(
                new int[][]{
                        {1, 1, 1, 0},
                        {1, 1, 1, 0},
                        {1, 1, 1, 0},
                        {0, 0, 0, 1}}));

    }
}
