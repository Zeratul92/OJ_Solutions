package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/*

 */
public class Algorithm_954_二倍数对数组 {
    public boolean canReorderDoubled(int[] arr) {
        int len = arr.length;
        int[] ordered = Arrays.stream(arr).boxed().sorted((a, b) ->
                a.equals(b) ? 0 : (Math.abs(a) - Math.abs(b) == 0 ? a - b : Math.abs(a) - Math.abs(b)))
                .mapToInt(Integer::intValue).toArray();

        Deque<Integer> deque = new LinkedList<>();
        int idx = 0;
        while (idx < len) {
            int cur = ordered[idx];
            idx++;
            if (deque.isEmpty()) {
                deque.addLast(cur);
                continue;
            }
            int head = deque.getFirst();
            if (head * 2 == cur) {
                deque.pollFirst();
                continue;
            }
            if (Math.abs(head * 2) < Math.abs(cur)) return false;
            deque.addLast(cur);
//            System.out.println(deque);
        }

        return deque.isEmpty();
    }

    public static void main(String[] args) {


        Algorithm_954_二倍数对数组 s = new Algorithm_954_二倍数对数组();
        System.out.println(s.canReorderDoubled(new int[]{4,-2,2,-4}));
        System.out.println(s.canReorderDoubled(new int[]{2,1,2,6}));
        System.out.println(s.canReorderDoubled(new int[]{1,2,4,16,8,4}));
    }
}
