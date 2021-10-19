package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_874_模拟行走机器人 {

    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];
            map.putIfAbsent(x, new HashMap<>());
            map.get(x).put(y, true);
        }

        int dirIdx = 0;
        int curX = 0, curY = 0;
        for (int command : commands) {
            if (command == -1) {
                dirIdx = (dirIdx + 1) % 4;
            } else if (command == -2) {
                dirIdx = (dirIdx + 4 - 1) % 4;
            } else {
                for (int i = 1; i <= command; i++) {
                    int x = curX + dir[dirIdx][0];
                    int y = curY + dir[dirIdx][1];
                    if (map.getOrDefault(x, new HashMap<>()).getOrDefault(y, false)) {
                        break;
                    }
                    curX = x;
                    curY = y;
                    ans = Math.max(ans, x * x + y * y);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_874_模拟行走机器人 s = new Algorithm_874_模拟行走机器人();
        System.out.println(s.robotSim(new int[]{4,-1,3}, new int[][]{}));
        System.out.println(s.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
    }
}
