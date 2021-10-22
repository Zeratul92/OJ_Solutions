package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*

 */
public class Algorithm_763_划分字母区间 {

    public List<Integer> partitionLabels(String s) {
        int len = s.length();
        int alphaLen = 26;
        int[] last = new int[alphaLen];
        Arrays.fill(last, -1);
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            last[cs[i] - 'a'] = i;
        }
        List<Integer> list = new LinkedList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            if (i <= end) {
                end = Math.max(end, last[cs[i] - 'a']);
            } else {
                list.add(end - start + 1);
                start = i;
                end = last[cs[i] - 'a'];
            }
        }
        list.add(end - start + 1);
        return list;
    }

    public static void main(String[] args) {


        Algorithm_763_划分字母区间 s = new Algorithm_763_划分字母区间();
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));

    }
}
