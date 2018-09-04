package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Algorithm_888_Fair_Candy_Swap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int a : A) {
            sumA += a;
        }
        for (int b : B) {
            sumB += b;
        }
        int avg = (sumA + sumB) >> 1;

        Set<Integer> setB = new HashSet<>();
        for (int b : B) {
            setB.add(b);
        }
        for (int a : A) {
            if (setB.contains(avg - (sumA - a))) {
                return new int[]{a, avg - (sumA - a)};
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Algorithm_888_Fair_Candy_Swap solution = new Algorithm_888_Fair_Candy_Swap();
        
    }
}
