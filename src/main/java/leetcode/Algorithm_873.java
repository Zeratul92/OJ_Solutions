package leetcode;

/**
 * <a href='https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/description/'>Length of Longest Fibonacci Subsequence</a><br>
 */
public class Algorithm_873 {


    public int lenLongestFibSubseq(int[] A) {
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < A.length; j++) {
                dp[i][j] = 2;
            }
        }

        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int ak = A[i] + A[j];
                int left = j + 1;
                int right = A.length - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (A[mid] == ak) {
                        left = mid;
                        break;
                    } else if (A[mid] < ak) {
                        left = mid + 1;
                    } else if (A[mid] > ak) {
                        right = mid;
                    }
                }
                if (left >= A.length || A[left] != ak) {
                    continue;
                }
                // found
                dp[j][left] = Math.max(dp[j][left], dp[i][j] + 1);
                ans = Math.max(ans, dp[j][left]);
//                if (dp[j][left] > 3) {
//                    System.out.println(Algorithm_876[i] + " " + Algorithm_876[j] + " " + Algorithm_876[left] + ": " + dp[j][left]);
//                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Algorithm_873 al = new Algorithm_873();
        System.out.println(al.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println();
        System.out.println(al.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
        System.out.println();
        int sz = 100;
        int begin = 3;
        int[] a = new int[sz];
        for (int i = begin; i < begin + sz; i++) {
            a[i - begin] = i;
        }
        System.out.println(al.lenLongestFibSubseq(a));
    }
}
