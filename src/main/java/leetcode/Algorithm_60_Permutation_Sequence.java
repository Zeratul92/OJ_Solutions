package leetcode;

public class Algorithm_60_Permutation_Sequence {
    private static int[] fac = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362800, 3628800};

    public String getPermutation(int n, int k) {
        boolean[] vis = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 0; i < n; i++) {
            int cnt = k / fac[n - i - 1];
            int unused = 0, idx = 1;
            while (true) {
                if (vis[idx]) {
                    idx++;
                    continue;
                }
                unused++;
                if (unused > cnt) {
                    break;
                }
                idx++;
            }
            vis[idx] = true;
            sb.append(idx);
            k -= cnt * fac[n - 1 - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Algorithm_60_Permutation_Sequence s = new Algorithm_60_Permutation_Sequence();
        System.out.println(s.getPermutation(5,1));
        System.out.println(s.getPermutation(5,2));
        System.out.println(s.getPermutation(5,3));
        System.out.println(s.getPermutation(5,4));
        System.out.println(s.getPermutation(5,5));
        System.out.println(s.getPermutation(5,24));
        System.out.println(s.getPermutation(5,25));
        System.out.println(s.getPermutation(5,120));
        System.out.println(s.getPermutation(5,119));
    }
}
