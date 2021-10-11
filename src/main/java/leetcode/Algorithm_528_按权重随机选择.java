package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*

 */
public class Algorithm_528_按权重随机选择 {
    private static class Solution {
        private int[] sumIdx;
        private int weightSum = 0;

        public Solution(int[] w) {
            sumIdx = new int[w.length];
            weightSum = 0;
            for (int i = 0; i < w.length; i++) {
                weightSum += w[i];
                sumIdx[i] = weightSum;
            }
        }

        public int pickIndex() {
            int left = 0;
            int right = sumIdx.length - 1;
            int mid;
            int rand = new Random().nextInt(weightSum) + 1;

            while (left < right) {
                mid = (left + right) >> 1;
                if (sumIdx[mid] == rand) {
                    return mid;
                } else if (sumIdx[mid] < rand) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            mid = (left + right) >> 1;
            return mid;
        }
    }

    public static void main(String[] args) {

        Algorithm_528_按权重随机选择 solution = new Algorithm_528_按权重随机选择();

        Solution s = new Solution(new int[]{1, 1, 2, 3, 5, 8});
        Map<Integer, Integer> map = new HashMap<>();
        int allTimes = 10000000;
        for (int i = 0; i < allTimes; i++) {
            int idx = s.pickIndex();
            map.put(idx, map.getOrDefault(idx, 0) + 1);
        }
        System.out.println(map);
        for (int idx : map.keySet()) {
            System.out.println(idx + ": " + map.get(idx) + " / " + allTimes + " = " + (double) map.get(idx) / allTimes);
        }
    }
}


