package leetcode;

/**
 * <a href='https://leetcode.com/problems/container-with-most-water/description/'>11. Container With Most Water</a>
 */
public class Algorithm_11_Container_With_Most_Water {
    /*
    Greedy algorithm, use two pointers i and j, let 1 <= i < j <= n
    Mind that the volume of the container is decided by the minimum of the two sides(min(ai, aj))
    Assume that ai < aj
    In order to find a larger volume,
    you need to move i to the right (let i = i + 1)
    instead of to move j to left (let j = j - 1),
    because aj is the longer side, it is irrelevant to the volume,
    to move this one can only narrow down the width (and even decrease the height)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Algorithm_11_Container_With_Most_Water a = new Algorithm_11_Container_With_Most_Water();
        System.out.println(a.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
