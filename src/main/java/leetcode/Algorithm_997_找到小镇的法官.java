package leetcode;

/*

 */
public class Algorithm_997_找到小镇的法官 {
    public int findJudge(int n, int[][] trust) {
        int ans = -1;
        boolean[][] edge = new boolean[n + 1][n + 1];
        for (int[] t : trust)
            edge[t[0]][t[1]] = true;
        for (int i = 1; i <= n; i++) {
            boolean potential = true;
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                if (edge[i][j]) {
                    potential = false;
                    break;
                }
            }
            if (!potential) continue;
            for (int j = 1; j <= n; j++) {
                if (j == i) continue;
                if (!edge[j][i]) {
                    potential = false;
                    break;
                }
            }
            if (potential) {
                if (ans != -1)
                    return -1;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_997_找到小镇的法官 s = new Algorithm_997_找到小镇的法官();
        System.out.println(s.findJudge(3, new int[][]{{1,3},{2,3}}));
    }
}
