package leetcode;

class RLEIterator {
    private int[] nums;
    private int[] times;
    private int size;
    private int idx;


    public RLEIterator(int[] A) {
        idx = 0;
        size = A.length >> 1;
        nums = new int[size];
        times = new int[size];
        for (int i = 0; i < size; i++) {
            times[i] = A[i * 2];
            nums[i] = A[i * 2 + 1];
        }
    }

    public int next(int n) {
        while (idx < size) {
            if (times[idx] == n) {
                times[idx] = 0;
                idx++;
                return nums[idx - 1];
            } else if (times[idx] < n) {
                n -= times[idx];
                times[idx] = 0;
                idx++;
            } else {
                times[idx] -= n;
                return nums[idx];
            }
        }
        return -1;
    }
}

public class Algorithm_900_RLE_Iterator {


    public static void main(String[] args) {
        Algorithm_900_RLE_Iterator s = new Algorithm_900_RLE_Iterator();

        int[] a = {3, 8, 0, 9, 2, 5};
        RLEIterator it = new RLEIterator(a);
        System.out.println(it.next(4));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
    }
}
