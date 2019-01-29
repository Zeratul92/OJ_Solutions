public class Array {

    private static int getReversePairCnt(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] copy = new int[a.length];
        int[] backup = new int[a.length];
        System.arraycopy(a, 0, copy, 0, a.length);
        System.arraycopy(a, 0, backup, 0, a.length);
        int ret = mergeCount(a, copy, 0, a.length - 1);
        System.arraycopy(backup, 0, a, 0, a.length);
        printArray(a);
        return ret;
    }

    private static int mergeCount(int[] a, int[] copy, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        int lCnt = mergeCount(copy, a, l, mid);
        int rCnt = mergeCount(copy, a, mid + 1, r);

        int i = mid, j = r;
        int pos = r;
        int cnt = 0;
        while (i >= l && j >= mid + 1) {
            if (a[i] > a[j]) {
                copy[pos--] = a[i--];
                cnt += j - mid;
            } else {
                copy[pos--] = a[j--];
            }
        }
        while (i >= l) {
            copy[pos--] = a[i--];
        }
        while (j >= mid + 1) {
            copy[pos--] = a[j--];
        }
//        System.out.println("begin: " + l + ", r: " + r + ", cnt = " + cnt + ", left: " + lCnt + ", right = " + rCnt);
//        System.out.print("a: " + a.toString() + " ");
//        printArray(a);
//        System.out.print("c: " + copy.toString() + " ");
//        printArray(copy);
        return cnt + lCnt + rCnt;
    }


    private static void printArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i != a.length - 1) {
                sb.append(',').append(' ');
            } else {
                sb.append(']');
            }
        }
        System.out.println(sb);
    }

    private static void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    /**
     * <a href='https://www.cnblogs.com/mydesky2012/p/5620006.html'>Reference</a>
     * Get next permutation of the array, which rearranges numbers into the lexicographically next greater permutation of numbers.
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * @param nums the array
     */
    private static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // Find first a[i] that a[i] < a[i + 1], starting from the end of the array
        // If the whole array is in reverse order, then i = -1
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Starting from i + 1, find the rightmost a[j] that satisfy a[j] > a[i]
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            // swap(a[i], a[j - 1]) to ensure lexicographical order
            swap(nums, i, j - 1);
        }

        // Reverse [i + 1, i + 2, ..., length - 1], mind that if i == -1. this will reverse the whole array.
        int k = nums.length - 1;
        i++;
        while (i < k) {
            swap(nums, i, k);
            i++;
            k--;
        }
    }

    private static int[] str2Array(String str) {
        int[] ret = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ret[i] = str.charAt(i) - '0';
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] a = {2, 4, 3, 1};
        printArray(a);
        nextPermutation(a);
        printArray(a);


        String str = "315462";
        System.out.println(getReversePairCnt(str2Array(str)));

    }

}
