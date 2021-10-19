package leetcode;

/*

 */
public class Algorithm_868_二进制间距 {
    public int binaryGap(int n) {
        int ans = 0;
        int last = -1, idx = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                if (last != -1) {
                    ans = Math.max(ans, idx - last);
                }
                last = idx;
            }
            idx++;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_868_二进制间距 s = new Algorithm_868_二进制间距();
        System.out.println(s.binaryGap(1));
        System.out.println(s.binaryGap(2));
        System.out.println(s.binaryGap(3));
        System.out.println(s.binaryGap(4));
        System.out.println(s.binaryGap(5));
        System.out.println(s.binaryGap(6));
        System.out.println(s.binaryGap(7));
        System.out.println(s.binaryGap(9));
        System.out.println(s.binaryGap(10));
    }
}
