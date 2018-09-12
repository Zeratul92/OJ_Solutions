package leetcode;

import java.util.ArrayList;

public class Algorithm_851_Loud_and_Rich {
    private static ArrayList<Integer>[] lists;
    private static int[] personToQuiet;
    private static int[] ret;
    private static int[] quietToPerson;
    private static boolean[] vis;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        lists = new ArrayList[n];
        quietToPerson = new int[n];
        vis = new boolean[n];
        personToQuiet = quiet;
        for (int i = 0; i < n; i++) {
            quietToPerson[quiet[i]] = i;
            lists[i] = new ArrayList<>();
        }
        for (int[] pair : richer) {
            lists[pair[1]].add(pair[0]);
        }

        ret = new int[n];

        for (int i = 0; i < n; i++) {
            dfs(i);
        }

        return ret;
    }

    private void dfs(int person) {
//        System.out.println(person + ": " + lists[person]);
        if (vis[person]) {
            return;
        }

        int minQuiet = personToQuiet[person];
        if (lists[person].isEmpty()) {
            vis[person] = true;
            ret[person] = person;
            return;
        }
        for (int richerPerson : lists[person]) {
            if (!vis[richerPerson]) {
                dfs(richerPerson);
            }
            minQuiet = Math.min(minQuiet, personToQuiet[ret[richerPerson]]);
        }
        ret[person] = quietToPerson[minQuiet];
        vis[person] = true;
    }

    public static void main(String[] args) {
        Algorithm_851_Loud_and_Rich s = new Algorithm_851_Loud_and_Rich();
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] ret = s.loudAndRich(richer, quiet);
        StringBuilder sb = new StringBuilder();
        for (int i : ret) {
            sb.append(i).append(",");
        }
        System.out.println(sb);
    }
}
