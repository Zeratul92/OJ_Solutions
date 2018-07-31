package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href='https://leetcode.com/problems/longest-substring-without-repeating-characters/description/'>Longest Substring Without Repeating Characters</a>
 */
public class Algorithm_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // always make a.length <= b.length
        int[] a, b;
        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        } else {
            a = nums1;
            b = nums2;
        }
        int allLen = a.length + b.length;
        int halfLen = allLen >> 1;
        boolean oddLen = allLen % 2 == 1;
        // consider exception: a.length == 0
        if (a.length == 0) {
            if (oddLen) {
                return b[halfLen];
            } else {
                double x = b[halfLen - 1];
                double y = b[halfLen];
                return (x + y) / 2.0;
            }
        }
        // got no numbers from a
        if (b[halfLen - 1] <= a[0]) {
            if (oddLen) {
                return Math.min(b[halfLen], a[0]);
            } else {
                if (a.length == b.length) {
                    return ((double) b[a.length - 1] + a[0]) / 2.0;
                }
                double x = b[halfLen - 1];
                double y = Math.min(b[halfLen], a[0]);
                return (x + y) / 2.0;
            }
        }
        // got all numbers from a
        if (a[a.length - 1] <= b[halfLen - a.length]) {
            if (oddLen) {
                return b[halfLen - a.length];
            }
            if (a.length == b.length) {
                return ((double) a[a.length - 1] + b[0]) / 2.0;
            }
            return ((double) b[halfLen - a.length] + Math.max(b[halfLen - a.length - 1], a[a.length - 1])) / 2.0;
        }

        // general status
        int a1 = 0, a2 = a.length, b1 = 0, b2 = b.length;
        int aLeft = 0, aRight = a.length - 1;
        while (aLeft < aRight) {
            int aMid = (aLeft + aRight) >> 1;
            // find the first bi > a[aMid], if not exist, then let bi = b[b.length - 1]
            int aCur = a[aMid];
            int bLeft = 0, bRight = b.length - 1;
            while (bLeft < bRight) {
                int bMid = (bLeft + bRight) >> 1;
                int bCur = b[bMid];
                if (bCur <= aCur) {
                    bLeft = bMid + 1;
                }
                if (bCur > aCur) {
                    bRight = bMid;
                }
            }
            int aCnt = aMid + 1;
            int bCnt;
            if (bLeft == b.length - 1 && b[bLeft] <= aCur) {
                bCnt = b.length;
            } else if (bLeft == 0) {
                bCnt = 0;
            } else {
                if (b[bLeft] <= aCur) {
                    bCnt = bLeft + 1;
                } else {
                    bCnt = bLeft;
                }
            }
            if (aCnt + bCnt == halfLen) {
                // get half intervals for both array
                if (oddLen) {
                    return aCnt == a.length ?
                            b[bCnt] :
                            Math.min(a[aCnt], b[bCnt]);
                } else {
                    return aCnt == a.length ?
                            ((double) Math.max(a[a.length - 1], b[bCnt - 1]) + b[bCnt]) / 2.0 :
                            ((double) Math.max(a[aCnt - 1], b[bCnt - 1]) + Math.min(a[aCnt], b[bCnt])) / 2.0;
                }
            } else if (aCnt + bCnt > halfLen) {
                a2 = Math.min(a2, aCnt);
                b2 = Math.min(b2, bCnt);
                aRight = aMid;
            } else {
                a1 = Math.max(a1, aCnt);
                b1 = Math.max(b1, bCnt);
                aLeft = aMid + 1;
            }
        }
//        System.out.println(a1 + " " + a2);
//        System.out.println(b1 + " " + b2);
        if (oddLen) {
            return Math.min(b[halfLen - a1], a[a1]);
        } else {
            return ((double) b[halfLen - a1 - 1] + Math.min(b[halfLen - a1], a[a1])) / 2.0;
        }
    }

    public static void main(String[] args) {
        Algorithm_4 a3 = new Algorithm_4();
        System.out.println(a3.findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{-1, 3}));
        System.out.println(a3.findMedianSortedArrays(
                new int[]{1, 2, 2},
                new int[]{1, 2, 3}));
        System.out.println(a3.findMedianSortedArrays(
                new int[]{2},
                new int[]{1, 3, 4, 5}));
        System.out.println(a3.findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2, 4, 5}));
        System.out.println(a3.findMedianSortedArrays(
                new int[]{1, 2},
                new int[]{1, 2}));
    }
}
