package leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

 */
public class Algorithm_599_两个列表的最小索引总和 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> ansMap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int minIdx = list1.length + list2.length;
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int j = map1.get(list2[i]);
                minIdx = Math.min(minIdx, i + j);
                ansMap.put(list2[i], i + j);
            }
        }
        Set<String> ansSet = new HashSet<>();
        for (String key : ansMap.keySet()) {
            if (minIdx == ansMap.get(key)) {
                ansSet.add(key);
            }
        }
        String[] ret = new String[ansSet.size()];
        int idx = 0;
        for (String ans : ansSet) {
            ret[idx++] = ans;
        }
        return ret;
    }

    public static void main(String[] args) {

        Algorithm_599_两个列表的最小索引总和 solution = new Algorithm_599_两个列表的最小索引总和();
        String[] ans = solution.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
