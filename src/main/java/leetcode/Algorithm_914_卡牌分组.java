package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_914_卡牌分组 {
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : deck) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int last = 0;
        for (int value : map.values()) {
            if (last == 0) {
                last = value;
            } else {
                last = gcd(last, value);
            }
            if (last == 1) return false;
        }
        return true;
    }

    public static void main(String[] args) {


        Algorithm_914_卡牌分组 s = new Algorithm_914_卡牌分组();
        System.out.println(s.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(s.hasGroupsSizeX(new int[]{4, 1, 3}));
        System.out.println(s.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }
}
