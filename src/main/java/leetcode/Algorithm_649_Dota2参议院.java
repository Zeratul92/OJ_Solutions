package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class Algorithm_649_Dota2参议院 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> dQ = new LinkedList<>();
        int len = senate.length();
        for (int i = 0; i < len; i++) {
            if ('R' == senate.charAt(i)) {
                rQ.offer(i);
            } else {
                dQ.offer(i);
            }
        }
        while (!rQ.isEmpty() && !dQ.isEmpty()) {
            int rIdx = rQ.poll();
            int dIdx = dQ.poll();
            if (rIdx < dIdx) rQ.offer(rIdx + len);
            else dQ.offer(dIdx + len);
        }
        if (rQ.isEmpty()) return "Dire";
        else return "Radiant";
    }


    public static void main(String[] args) {

        Algorithm_649_Dota2参议院 solution = new Algorithm_649_Dota2参议院();

        System.out.println(solution.predictPartyVictory("RD"));
        System.out.println(solution.predictPartyVictory("RDD"));
        System.out.println(solution.predictPartyVictory("DDRRDRDRRDRDRDRDDRRRRDDRDRDRDRDRDDDRRRDRDRDRDRDRRRDDRRRDRRDDRDRDDRDRDDDRRRDD"));
    }
}
