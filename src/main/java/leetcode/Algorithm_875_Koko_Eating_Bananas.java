package leetcode;


import java.util.Arrays;

public class Algorithm_875_Koko_Eating_Bananas {
    public int minEatingSpeed(int[] piles, int H) {
//        System.out.println("H = " + H);
        int l = 1, r = 1;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
//            System.out.println("[" + l + ", " + r + "]");
            int mid = (l + r) >> 1;
            int hour = 0;
            for (int pile : piles) {
                hour += (pile + mid - 1) / mid;
            }
            if (hour <= H) {
                r = mid;
            } else {
                l = mid + 1;
            }
//            System.out.println(mid + ": " + hour);
        }
        int hour = 0;
        for (int pile : piles) {
            hour += (pile + l - 1) / l;
        }
        if (hour > H) {
            l--;
        }
        return l;
    }

    public static void main(String[] args) {
        Algorithm_875_Koko_Eating_Bananas s = new Algorithm_875_Koko_Eating_Bananas();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 4));
        System.out.println();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 5));
        System.out.println();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 6));
        System.out.println();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 7));
        System.out.println();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 9));
        System.out.println();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 10));
        System.out.println();
    }
}
