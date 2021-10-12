package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*

 */
public class Algorithm_658_找到K个最接近的元素 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().sorted((a, b) ->
                a.equals(b) ? 0 : (Math.abs(a - x) - Math.abs(b - x)) == 0 ? a - b : Math.abs(a - x) - Math.abs(b - x))
                .collect(Collectors.toList()).subList(0, k);
        ret.sort(Integer::compareTo);
        return ret;
    }

    public static void main(String[] args) {


        Algorithm_658_找到K个最接近的元素 s = new Algorithm_658_找到K个最接近的元素();
        System.out.println(s.findClosestElements(new int[]{1, 3, 5, 4, 7}, 2, 2));
        System.out.println(s.findClosestElements(new int[]{1, 3, 5, 4, 7}, 2, 3));
        System.out.println(s.findClosestElements(new int[]{1, 3, 5, 4, 7}, 2, 4));
        System.out.println(s.findClosestElements(new int[]{1, 3, 5, 4, 7}, 2, 5));
    }
}
