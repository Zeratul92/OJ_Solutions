package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*

 */
public class Algorithm_703_数据流中的第K大元素 {

    private static class KthLargest {
        private final PriorityQueue<Integer> pq;
        private final int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }

    public static void main(String[] args) {
        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }
}
