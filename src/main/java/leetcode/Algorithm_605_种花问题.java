package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * not finished
 */
public class Algorithm_605_种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (0 == n) return true;
        int ans = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (1 == flowerbed[i]) continue;
            if (i > 0 && 1 == flowerbed[i - 1]) continue;
            if (i < flowerbed.length - 1 && 1 == flowerbed[i + 1]) continue;
            flowerbed[i] = 1;
            ans++;
            if (ans >= n) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Algorithm_605_种花问题 solution = new Algorithm_605_种花问题();


        System.out.println(solution.canPlaceFlowers(new int[]{}, 3));
    }
}
