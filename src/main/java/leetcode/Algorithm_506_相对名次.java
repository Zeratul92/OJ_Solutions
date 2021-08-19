package leetcode;

import java.util.*;

/*

 */
public class Algorithm_506_相对名次 {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        if (len == 1)
            return new String[]{"Gold Medal"};
        if (len == 2)
            return score[0] > score[1] ? new String[]{"Gold Medal", "Silver Medal"} : new String[]{"Silver Medal", "Gold Medal"};
        int[] orderedScore = new int[len];
        for (int i = 0; i < len; i++) {
            orderedScore[i] = score[i];
        }
        Arrays.sort(orderedScore);
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (i == len - 1)
                map.put(orderedScore[i], "Gold Medal");
            else if (i == len - 2)
                map.put(orderedScore[i], "Silver Medal");
            else if (i == len - 3)
                map.put(orderedScore[i], "Bronze Medal");
            else
                map.put(orderedScore[i], Integer.toString(len - i));
        }
        String[] ret = new String[len];
        for (int i = 0; i < len; i++) {
            ret[i] = map.get(score[i]);
        }
        return ret;
    }


    public static void main(String[] args) {

        Algorithm_506_相对名次 solution = new Algorithm_506_相对名次();

        String[] ret = solution.findRelativeRanks(new int[]{5, 4, 3, 2, 1});

        for (String s : ret) {
            System.out.println(s);
        }
    }
}
