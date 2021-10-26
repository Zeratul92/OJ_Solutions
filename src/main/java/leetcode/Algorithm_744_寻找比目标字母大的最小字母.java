package leetcode;

/*

 */
public class Algorithm_744_寻找比目标字母大的最小字母 {

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        int idx = -1;
        int i = 0, j = len - 1;
        while (i < j) {
            int mid = (i + j) >> 1;
            if (letters[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        idx = (i + j) >> 1;
        if (letters[idx] <= target) return letters[(idx + 1) % len];
        return letters[idx % len];
    }

    public static void main(String[] args) {


        Algorithm_744_寻找比目标字母大的最小字母 s = new Algorithm_744_寻找比目标字母大的最小字母();
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(s.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));

    }
}
