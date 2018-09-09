package leetcode;

import java.util.Stack;

class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    public int next(int price) {
        int ret = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ret += stack.pop()[1];
        }
        stack.push(new int[]{price, ret});
        return stack.peek()[1];
    }
}

public class Algorithm_901_Online_Stock_Span {


    public static void main(String[] args) {
        Algorithm_901_Online_Stock_Span s = new Algorithm_901_Online_Stock_Span();
        StockSpanner stock = new StockSpanner();
        System.out.println(stock.next(10));
        System.out.println(stock.next(9));
        System.out.println(stock.next(8));
        System.out.println(stock.next(7));
        System.out.println(stock.next(11));
        System.out.println(stock.next(8));
        System.out.println(stock.next(10));
        System.out.println(stock.next(11));
    }
}
