package leetcode;

import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    Stack<Stack<Integer>> stacks = new Stack<>();

    public FreqStack() {
    }

    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0);
        freq++;
        freqMap.put(x, freq);
        if (freq > stacks.size()) {
            stacks.push(new Stack<>());
        }
        stacks.get(freq - 1).push(x);
    }

    public int pop() {
        int x = stacks.peek().pop();
        if (stacks.peek().isEmpty()) {
            stacks.pop();
        }
        freqMap.put(x, freqMap.get(x) - 1);
        return x;
    }
}

public class Algorithm_895_Maximum_Frequency_Stack {

    public static void main(String[] args) {
        Algorithm_895_Maximum_Frequency_Stack solution = new Algorithm_895_Maximum_Frequency_Stack();

        FreqStack fs = new FreqStack();
        fs.push(4);
        fs.push(0);
        fs.push(9);
        fs.push(3);
        fs.push(4);
        fs.push(2);
        System.out.println(fs.pop());
        fs.push(6);
        System.out.println(fs.pop());
        fs.push(1);
        System.out.println(fs.pop());
        fs.push(1);
        System.out.println(fs.pop());
        fs.push(4);
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
        System.out.println(fs.pop());
    }
}
