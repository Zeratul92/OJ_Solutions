package leetcode;

/*

 */
public class Algorithm_984_不含AAA或BBB的字符串 {

    public String strWithout3a3b(int a, int b) {
        boolean goA = false, goB = false;
        StringBuilder sb = new StringBuilder(a + b);
        while (a > 0 || b > 0) {
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'a' && sb.charAt(sb.length() - 2) == 'a') {
                sb.append('b');
                b--;
                continue;
            }
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == 'b' && sb.charAt(sb.length() - 2) == 'b') {
                sb.append('a');
                a--;
                continue;
            }
            if (a > b) {
                sb.append('a');
                a--;
            } else {
                sb.append('b');
                b--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Algorithm_984_不含AAA或BBB的字符串 s = new Algorithm_984_不含AAA或BBB的字符串();
        System.out.println(s.strWithout3a3b(3, 3));
        System.out.println(s.strWithout3a3b(1, 2));
        System.out.println(s.strWithout3a3b(4, 1));
        System.out.println(s.strWithout3a3b(1, 4));
    }
}
