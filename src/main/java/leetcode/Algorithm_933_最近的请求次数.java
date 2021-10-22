package leetcode;

import java.util.PriorityQueue;

/*

 */
public class Algorithm_933_最近的请求次数 {


    public static void main(String[] args) {

        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}
class RecentCounter {

    private final PriorityQueue<Integer> pq;

    public RecentCounter() {
        pq = new PriorityQueue<>();
    }

    public int ping(int t) {
        pq.add(t);
        while (!pq.isEmpty() && pq.peek() < t - 3000) {
            pq.poll();
        }

        return pq.size();
    }
}