package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algorithm_870_Advantage_Shuffle {

    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] ret = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.sort(A);
        for (int i = 0; i < n; i++) {
            int b = B[i];
            int idx = Arrays.binarySearch(A, b);
            if (idx < 0) {
                idx = -idx - 1;
            } else {
                idx++;
            }
            while (idx < n && (vis[idx] || A[idx] <= b)) {
                idx++;
            }
            if (idx >= n) {
                for (int j = 0; j < vis.length; j++) {
                    if (!vis[j]) {
                        idx = j;
                        break;
                    }
                }
            }
            ret[i] = A[idx];
            vis[idx] = true;
        }
        return ret;
    }


    public static void main(String[] args) {
        Algorithm_870_Advantage_Shuffle al = new Algorithm_870_Advantage_Shuffle();



        int[] a = {2,0,4,1,2};
        int[] b = {1,3,0,0,2};

        int[] ret = al.advantageCount(a, b);
        for (int i : ret) {
            System.out.print(i + ",");
        }
        System.out.println();

    }
}
