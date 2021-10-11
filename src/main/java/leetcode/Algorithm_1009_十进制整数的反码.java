package leetcode;

/*

 */
public class Algorithm_1009_十进制整数的反码 {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int temp = 0;
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                temp += 1 << cnt;
            }
            n >>= 1;
            cnt++;
        }
        return temp;
    }


    public static void main(String[] args) {

        Algorithm_1009_十进制整数的反码 solution = new Algorithm_1009_十进制整数的反码();

        System.out.println(solution.bitwiseComplement(1));
        System.out.println(solution.bitwiseComplement(2));
        System.out.println(solution.bitwiseComplement(3));
        System.out.println(solution.bitwiseComplement(4));
        System.out.println(solution.bitwiseComplement(5));
        System.out.println(solution.bitwiseComplement(6));
    }
}
