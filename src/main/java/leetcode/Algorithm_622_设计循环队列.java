package leetcode;

/**
 *
 */
public class Algorithm_622_设计循环队列 {

    private static class MyCircularQueue {
        private final int size;
        private final int[] arr;
        private int cnt;
        private int head;
        private int tail;

        public MyCircularQueue(int k) {
            size = k;
            arr = new int[size];
            cnt = 0;
            head = 0;
            tail = -1;
        }

        public boolean enQueue(int value) {
            if (cnt == size) return false;
            tail = (tail + 1) % size;
            arr[tail] = value;
            cnt++;
            return true;
        }

        public boolean deQueue() {
            if (cnt == 0) return false;
            head = (head + 1) % size;
            cnt--;
            return true;
        }

        public int Front() {
            if (cnt == 0) return -1;
            return arr[head];
        }

        public int Rear() {
            if (cnt == 0) return -1;
            return arr[tail];
        }

        public boolean isEmpty() {
            return cnt == 0;
        }

        public boolean isFull() {
            return cnt == size;
        }
    }



    public static void main(String[] args) {

        Algorithm_622_设计循环队列 solution = new Algorithm_622_设计循环队列();


    }
}
