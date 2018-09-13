package leetcode;

import java.util.ArrayList;

public class Algorithm_852_Peak_Index_in_a_Mountain_Array {
    public int peakIndexInMountainArray(int[] A) {
        int l = 1, r = A.length - 2;
        while (l < r) {
            int mid = (l + r) >> 1;
//            System.out.println(mid + ": " + A[mid]);
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        Algorithm_852_Peak_Index_in_a_Mountain_Array s = new Algorithm_852_Peak_Index_in_a_Mountain_Array();
        int[] a = {1, 2, 4, 5, 6, 7, 8, 7, 6, 4, 3};
        int[] b = {1, 2, 4, 7, 6, 5, 4, 3};
        int[] c = {1, 2, 0};
        System.out.println(s.peakIndexInMountainArray(a));
        System.out.println(s.peakIndexInMountainArray(b));
        System.out.println(s.peakIndexInMountainArray(c));
    }
}
