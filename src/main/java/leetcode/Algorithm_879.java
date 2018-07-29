package leetcode;

/**
 * <a href='https://leetcode.com/problems/profitable-schemes/description/'>Profitable Schemes</a>
 * Classic Knapsack DP issue
 */
public class Algorithm_879 {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int size = group.length; // size of events
        long MOD = 1000000007L;
        // dp[i][j] means how many way there are by using strictly i people to get strictly j profit(if j > P, then make j = p)
        long[][] dp = new long[G + 1][P + 1];
        dp[0][0] = 1;
        // traverse all the event
        for (int idx = 0; idx < size; idx++) {
            int curG = group[idx];
            int curP = profit[idx];
            // backward traverse in case that add up the same value repeatedly
            for (int g0 = G - curG; g0 >= 0; g0--) {
                for (int p0 = P; p0 >= 0; p0--) {
                    if (dp[g0][p0] == 0) {
                        continue;
                    }
                    int g = g0 + curG;
                    int p = Math.min(P, p0 + curP);
                    dp[g][p] = (dp[g][p] + dp[g0][p0]) % MOD;
//                    StringBuilder sb = new StringBuilder();
//                    sb.append("#").append(idx).append(": ").append(curG).append("人").append(curP).append("钱, ");
//                    sb.append("dp[").append(g).append("][").append(p).append("] = ").append(dp[g][p]);
//                    System.out.println(sb);
                }
            }
        }
        long ans = 0;
        // add up all the result that make the profit to P
        for (int i = 0; i <= G; i++) {
            ans = (ans + dp[i][P]) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Algorithm_879 solution = new Algorithm_879();
        System.out.println(solution.profitableSchemes(10, 5,
                new int[]{2, 3, 5},
                new int[]{6, 7, 8}));

        System.out.println();
        System.out.println(solution.profitableSchemes(8, 12,
                new int[]{5, 3, 2, 1, 2, 3, 4},
                new int[]{7, 5, 4, 3, 5, 4, 5}));
    }
}
