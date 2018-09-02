package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Algorithm_55_Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        if (nums[0] >= nums.length - 1) {
            return true;
        }
        int pos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= pos) {
                pos = i;
            }
        }
        return pos <= 0;
    }

    public static void main(String[] args) {
        Algorithm_55_Jump_Game s = new Algorithm_55_Jump_Game();
        System.out.println(s.canJump(new int[]{1, 2, 3}));
    }
}
