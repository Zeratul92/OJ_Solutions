package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*

 */
public class Algorithm_497_非重叠矩形中的随机点 {
    private static class Solution {

        private int[] cnt;
        private int len;
        private int[][] rects;
        private int sumCnt;

        public Solution(int[][] rects) {
            this.rects = rects;
            len = rects.length;
            cnt = new int[len];
            int tempSum = 0;
            for (int i = 0; i < len; i++) {
                tempSum += (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
                cnt[i] = tempSum;
            }
            sumCnt = tempSum;
        }

        public int[] pick() {
            int rand = new Random().nextInt(sumCnt) + 1;
//            System.out.println("rand = " + rand);
            int left = 0, right = len - 1;
            int idx;
            while (left < right) {
                idx = (left + right) >> 1;
                if (cnt[idx] == rand) {
                    break;
                } else if (cnt[idx] < rand) {
                    left = idx + 1;
                } else {
                    right = idx;
                }
            }
            idx = (left + right) >> 1;
//            System.out.println("idx = " + idx + ": " + cnt[idx]);
            int pre = idx == 0 ? 1 : cnt[idx - 1] + 1;
            int cur = rand - pre;

            return new int[]{
                    rects[idx][0] + cur / (rects[idx][3] - rects[idx][1] + 1),
                    rects[idx][1] + cur % (rects[idx][3] - rects[idx][1] + 1),
            };
        }
    }


    public static void main(String[] args) {

        int[][] r = new int[][]{
                {1, 1, 5, 5},
                {7, 7, 9, 11},
                {100, 100, 107, 104},
                {200, 300, 219, 300},
        };

        Solution s = new Solution(r);
        Map<Integer, Integer> map = new HashMap<>();
        int tryTimes = 10000020;
        for (int i = 0; i < tryTimes; i++) {
            int[] c = s.pick();
//            System.out.println("(" + c[0] + ", " + c[1] + ")");
            for (int idx = 0; idx < r.length; idx++) {
                if (r[idx][0] <= c[0] && c[0] <= r[idx][2]&& r[idx][1] <= c[1] && c[1] <= r[idx][3]) {
                    map.put(idx, map.getOrDefault(idx, 0) + 1);
                    break;
                }
            }
        }
        System.out.println(map);
        for (int idx : map.keySet()) {
            int cnt = map.get(idx);
            System.out.println(idx + ": " + cnt + ", " + ((double)cnt / tryTimes));
        }
    }
}
