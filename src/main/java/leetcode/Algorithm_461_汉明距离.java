package leetcode;

/*

 */
public class Algorithm_461_汉明距离 {
    public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int ans = 0;
        while (temp > 0) {
            ans += temp & 1;
            temp >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {


        Algorithm_461_汉明距离 s = new Algorithm_461_汉明距离();
        System.out.println(s.hammingDistance(2, 3));
        System.out.println(s.hammingDistance(1, 4));
        System.out.println(s.hammingDistance(3, 1));
    }
}
