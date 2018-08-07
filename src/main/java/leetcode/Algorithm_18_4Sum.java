package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <a href='https://leetcode.com/problems/4sum/description/'>18. 4Sum</a>
 */
public class Algorithm_18_4Sum {
    /**
     * A recursive method to get n numbers from the array nums whose sum equals target.
     * For example if n equals 3, it should return [[a1, a2, a3], [b1, b2, b3], ...]
     * @param nums the array
     * @param target the target of the numbers' sum
     * @param n the amount of the numbers
     * @return a List object consists of every distinctive list where the numbers' sum equals target
     */
    private List<List<Integer>> findSum(int[] nums, int target, int n) {
        if (n < 2 || nums.length < n) {
            return new ArrayList<>();
        }
        if (n == 2) {
            // use two pointers to find if there is a[l] + a[r] == target
            int l = 0;
            int r = nums.length - 1;
            List<List<Integer>> ret = new ArrayList<>();
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    // add
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[l]);
                    cur.add(nums[r]);
                    ret.add(cur);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return ret;
        } else {
            List<List<Integer>> ret = new ArrayList<>();
            for (int i = 0; i < nums.length - n + 1; i++) {
                if (nums[i] * n > target || target > nums[nums.length - 1] * n) {
                    break;
                }
                if (i == 0 || nums[i] != nums[i - 1]) {
                    List<List<Integer>> found = findSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i], n - 1);
                    for (List<Integer> list : found) {
                        list.add(nums[i]);
                        ret.add(list);
                    }
                }
            }
            return ret;
        }
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = findSum(nums, target, 4);
        return ret;
    }

    /*
     * low efficiency
     */
    public List<List<Integer>> fourSumOld(int[] nums, int target) {

        Set<List<Integer>> ansSet = new HashSet<>();
        Map<Integer, List<Integer>> sums = new HashMap<>();
        Map<Integer, Integer> times = new HashMap<>();

        for (int n : nums) {
            if (!times.containsKey(n)) {
                times.put(n, 0);
            }
            times.put(n, times.get(n) + 1);
            for (int m : nums) {
                if (!sums.containsKey(n + m)) {
                    sums.put(n + m, new ArrayList<>());
                }
                sums.get(n + m).add(Math.min(n, m));
            }
        }

        for (int sum1 : sums.keySet()) {
            int sum2 = target - sum1;
            if (!sums.containsKey(sum2)) {
                continue;
            }
            for (int a : sums.get(sum1)) {
                int b = sum1 - a;
                if (a == b && times.get(a) < 2) {
                    continue;
                }
                for (int c : sums.get(sum2)) {
                    int d = sum2 - c;
                    if (c == d && times.get(c) < 2) {
                        continue;
                    }
                    if (a == c && times.get(a) < 2) {
                        continue;
                    }
                    if (a == d && times.get(a) < 2) {
                        continue;
                    }
                    if (b == c && times.get(b) < 2) {
                        continue;
                    }
                    if (b == d && times.get(b) < 2) {
                        continue;
                    }
                    if (a == b && b == c && times.get(a) < 3) {
                        continue;
                    }
                    if (a == b && b == d && times.get(a) < 3) {
                        continue;
                    }
                    if (a == c && c == d && times.get(c) < 3) {
                        continue;
                    }
                    if (b == c && c == d && times.get(c) < 3) {
                        continue;
                    }
                    if (a == b && b == c && c == d && times.get(a) < 4) {
                        continue;
                    }
                    int[] quadruplet = new int[]{a, b, c, d};
                    Arrays.sort(quadruplet);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(quadruplet[0]);
                    temp.add(quadruplet[1]);
                    temp.add(quadruplet[2]);
                    temp.add(quadruplet[3]);
                    ansSet.add(temp);
                }
            }
        }

        return new ArrayList<>(ansSet);
    }

    public static void main(String[] args) {

        Algorithm_18_4Sum s = new Algorithm_18_4Sum();
//        System.out.println(s.fourSumOld(new int[]{}, 0));
        System.out.println(s.fourSum(new int[]{3, 2, -3, 3, 0, 2, 1, 2, 3, 0, 4, 2, 4, 1, 2, 3, 1, 1, 0, 0, 0, 0, -2, -3, -4, -3, 2, -3, -4, -5, -5, 5, 5, 5, -4}, 17));
//        System.out.println(s.fourSumOld(new int[]{3, 2, -3, 3, 0, 2, 1, 2, 3, 0, 4, 2, 4, 1, 2, 3, 1, 1, 0, 0, 0, 0, -2, -3, -4, -3, 2, -3, -4, -5, -5, 5, 5, 5, -4}, 2));
//        System.out.println(s.fourSumOld(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(s.fourSumOld(new int[]{-1, 0, 1, 2, -1, -4}, 3));
    }
}
