package leetcode;


import java.util.HashSet;
import java.util.Set;

public class Algorithm_898_Bitwise_ORs_of_Subarrays {
    public int subarrayBitwiseORs(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Set<Integer> result = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int a : A) {
            Set<Integer> next = new HashSet<>();
            cur.forEach(n -> next.add(a | n));
            next.add(a);
            cur = next;
            result.addAll(cur);
        }
        return result.size();
    }
    public static void main(String[] args) {
        Algorithm_898_Bitwise_ORs_of_Subarrays s = new Algorithm_898_Bitwise_ORs_of_Subarrays();
        System.out.println(s.subarrayBitwiseORs(new int[]{1,2,4}));
        System.out.println(s.subarrayBitwiseORs(new int[]{1,1,2}));
        System.out.println(s.subarrayBitwiseORs(new int[]{2,1,1}));
    }
}
