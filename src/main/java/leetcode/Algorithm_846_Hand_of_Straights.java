package leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Algorithm_846_Hand_of_Straights {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int h : hand) {
            pq.add(h);
        }

        while (!pq.isEmpty()) {
            int min = pq.poll();
            for (int i = 1; i < W; i++) {
                if (!pq.remove(min + i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Algorithm_846_Hand_of_Straights s = new Algorithm_846_Hand_of_Straights();
        int[] hand = {1,2,3,6,2,3,4,7,8};
        System.out.println(s.isNStraightHand(hand, 3));
    }
}
