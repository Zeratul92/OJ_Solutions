package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Algorithm_886_Possible_Bipartition {

    private boolean dfs(List<Integer>[] mat, int x, int group, Map<Integer, Integer> groupMap) {
        if (groupMap.containsKey(x)) {
            // return false if the current node's group inconsistent with the record in groupMap
            return groupMap.get(x) == group;
        }
        groupMap.put(x, group);
        for (int next : mat[x]) {
            // put node 'next' into the other group
            if (!dfs(mat, next, group ^ 1, groupMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(List<Integer>[] mat, int N) {
        int[] color = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int x = queue.poll();
                    for (int next : mat[x]) {
                        if (color[next] == 0) {
                            color[next] = color[x] == 1 ? 2 : 1;
                            queue.add(next);
                        } else if (color[next] == color[x]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] adjacentMat = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adjacentMat[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adjacentMat[a].add(b);
            adjacentMat[b].add(a);
        }

        boolean goBfs = true;
        if (goBfs) {
            return bfs(adjacentMat, N);
        }

        Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (groupMap.containsKey(i)) {
                continue;
            }
            if (!dfs(adjacentMat, i, 0, groupMap)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Algorithm_886_Possible_Bipartition solution = new Algorithm_886_Possible_Bipartition();
//        int[][] dis = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 1}};
        int[][] dis = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
//        int[][] dis = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println(solution.possibleBipartition(5, dis));
    }
}
