package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*

 */
public class Algorithm_1046_最后一块石头的重量 {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) pq.add(Math.abs(x - y));
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }

    public static void main(String[] args) {


        Algorithm_1046_最后一块石头的重量 s = new Algorithm_1046_最后一块石头的重量();
        System.out.println(s.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
