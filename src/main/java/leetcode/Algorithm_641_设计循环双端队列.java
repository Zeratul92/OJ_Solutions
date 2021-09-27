package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class Algorithm_641_设计循环双端队列 {

    private static class MyCircularDeque {
        private final int size;
        private final int[] arr;
        private int cnt;
        private int head;
        private int tail;


        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            size = k;
            arr = new int[size];
            head = 0;
            tail = size - 1;
            cnt = 0;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (cnt >= size) return false;
            head = (head - 1 + size) % size;
            arr[head] = value;
            cnt++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (cnt >= size) return false;
            tail = (tail + 1) % size;
            arr[tail] = value;
            cnt++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (0 == cnt) return false;
            head = (head + 1) % size;
            cnt--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (0 == cnt) return false;
            tail = (tail - 1 + size) % size;
            cnt--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (0 == cnt) return -1;
            return arr[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (0 == cnt) return -1;
            return arr[tail];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return 0 == cnt;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == cnt;
        }
    }

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */




    public static void main(String[] args) {

        Algorithm_641_设计循环双端队列 solution = new Algorithm_641_设计循环双端队列();

        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));	// 返回 true
        System.out.println(circularDeque.insertLast(2));	// 返回 true
        System.out.println(circularDeque.insertFront(3));	// 返回 true
        System.out.println(circularDeque.insertFront(4));	// 已经满了，返回 false
        System.out.println(circularDeque.getRear());  			// 返回 2
        System.out.println(circularDeque.isFull());				// 返回 true
        System.out.println(circularDeque.deleteLast());			// 返回 true
        System.out.println(circularDeque.insertFront(4));	// 返回 true
        System.out.println(circularDeque.getFront());			// 返回 4
        System.out.println(circularDeque.getRear());			// 返回 2
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.insertLast(2));	// 返回 true
        System.out.println(circularDeque.insertFront(3));	// 返回 true
        System.out.println(circularDeque.getFront());			// 返回 3
        System.out.println(circularDeque.getRear());			// 返回 2

    }
}
