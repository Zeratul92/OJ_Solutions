package leetcode;

import java.util.Stack;

public class Algorithm_739_Daily_Temperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        int n = temperatures.length;
        if (n == 1) {
            return new int[]{0};
        }
        int[] ret = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }

        return ret;
    }

    public static void main(String[] args) {
        Algorithm_739_Daily_Temperatures s = new Algorithm_739_Daily_Temperatures();
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ret = s.dailyTemperatures(temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
            System.out.print(i == temp.length - 1 ? "\n" : "\t");
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]);
            System.out.print(i == ret.length - 1 ? "\n" : "\t");
        }
    }
}
