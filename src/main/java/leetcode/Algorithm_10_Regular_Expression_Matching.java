package leetcode;

/**
 * <a href='https://leetcode.com/problems/regular-expression-matching/description/'>10. Regular Expression Matching</a>
 * DP problem O(nm) time complexity. (n and m are length of string s and p)
 */
public class Algorithm_10_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (p.equals(".*")) {
            // ".*" can be any String
            return true;
        }
        // dp[i][j] means if s[1, 2, ..., i] can be matched to p[1, 2, 3, ..., j]
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            // mind that t would not start with '*', so just begin with index 1
            // if p looks like "a*b*c*d*..."
            dp[0][i + 1] = dp[0][i - 1] && p.charAt(i) == '*';
        }

        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            int lenI = i + 1;
            for (int j = 0; j < p.length(); j++) {
                char cj = p.charAt(j);
                int lenJ = j + 1;
                if (cj == ci || cj == '.') {
                    // cj matched to ci
                    dp[lenI][lenJ] = dp[lenI - 1][lenJ - 1];
                    continue;
                }
                if (cj == '*') {
                    // Need to consider the letter before cj(cj0).
                    char cj0 = p.charAt(j - 1);
                    if (cj0 == ci || cj0 == '.') {
                        // if cj0 matched to ci, use an 'a' to replace this letter.
                        // "a*" can be matched to a single 'a', then need to inquire dp[lenI][lenJ-1],
                        // "a*" can be matched to multiple 'a's, then need to inquire dp[lenI-1][lenJ],
                        // "a*" can be matched to just empty "", then need to inquire dp[lenI-1][lenJ-2].
                        // If one of these three is true(that is, the strings before matched), then dp[lenI][lenJ] is true.
                        dp[lenI][lenJ] = dp[lenI][lenJ - 2] || dp[lenI][lenJ - 1] || dp[lenI - 1][lenJ];
                    } else {
                        // cj0 not matched to ci, (cj0, cj) must be considered as empty (inquire dp[lenI-1][lenJ-2])
                        dp[lenI][lenJ] = dp[lenI][lenJ - 2];
                    }
                    continue;
                } else {
                    // current ci and cj not matched, do nothing(initially false)
//                    dp[lenI][lenJ] = false;
                    continue;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Algorithm_10_Regular_Expression_Matching s = new Algorithm_10_Regular_Expression_Matching();
        System.out.println(s.isMatch("a", "a"));
        System.out.println(s.isMatch("a", "."));
        System.out.println(s.isMatch("n", "a*"));
        System.out.println(s.isMatch("", "a*"));
        System.out.println(s.isMatch("aabb", "a..*"));
        System.out.println(s.isMatch("aab", "c*a*b"));
        System.out.println(s.isMatch("mississippi", "mis*is*p*."));
    }
}
