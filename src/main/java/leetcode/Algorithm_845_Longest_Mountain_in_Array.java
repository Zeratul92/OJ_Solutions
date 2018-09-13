package leetcode;

import java.util.PriorityQueue;

public class Algorithm_845_Longest_Mountain_in_Array {

    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int ans = 0;
        int incLow = -1, incHigh = -1, decLow = -1, decHigh = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (incLow != -1 && incHigh != -1 && decLow != -1 && decHigh != -1 && incHigh == decLow) {
                ans = Math.max(ans, decHigh - incLow + 1);
            }

            if (A[i] == A[i + 1]) {
                incLow = -1;
            } else if (A[i] < A[i + 1]) {

                if (incHigh != i || incLow == -1) {
                    incLow = i;
                }
                incHigh = i + 1;

                if (decHigh != -1) {
                    decLow = -1;
                    decHigh = -1;
                }

            } else {
                if (decLow == -1) {
                    decLow = i;
                }
                decHigh = i + 1;
            }
        }
        if (incLow != -1 && incHigh != -1 && decLow != -1 && decHigh != -1 && incHigh == decLow) {
            ans = Math.max(ans, decHigh - incLow + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Algorithm_845_Longest_Mountain_in_Array s = new Algorithm_845_Longest_Mountain_in_Array();
        int[] a = {1,2,0,2,0,2};
        System.out.println(s.longestMountain(a));
    }
}
