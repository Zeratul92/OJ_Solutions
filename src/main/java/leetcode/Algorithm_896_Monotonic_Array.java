package leetcode;


public class Algorithm_896_Monotonic_Array {

    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        boolean increasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increasing = false;
                break;
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            if ((increasing && A[i] <= A[i + 1]) || (!increasing && A[i] >= A[i + 1])) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Algorithm_896_Monotonic_Array s = new Algorithm_896_Monotonic_Array();
        System.out.println(s.isMonotonic(new int[]{1,2,3}));
        System.out.println(s.isMonotonic(new int[]{1,3,3}));
        System.out.println(s.isMonotonic(new int[]{1,4,3}));
        System.out.println(s.isMonotonic(new int[]{1,2,2,1}));
        System.out.println(s.isMonotonic(new int[]{1,2,2,2}));
        System.out.println(s.isMonotonic(new int[]{2,2,2,1}));
        System.out.println(s.isMonotonic(new int[]{2,2,2,3}));
        System.out.println(s.isMonotonic(new int[]{1,2,2,3}));
        System.out.println(s.isMonotonic(new int[]{1,2,3,3}));
    }
}
