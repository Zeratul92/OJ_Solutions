package leetcode;

/**
 * <a href='https://leetcode.com/problems/zigzag-conversion/description/'>6. ZigZag Conversion</a>
 */
public class Algorithm_6_ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        // first row(row 0)
        while (true) {
            if (idx >= s.length()) {
                break;
            }
            sb.append(s.charAt(idx));
            idx += 2 * (numRows - 1);
        }
        // row 2, 3, ..., numRows - 1
        for (int i = 2; i <= numRows - 1; i++) {
            idx = i - 1;
            while (true) {
                if (idx >= s.length()) {
                    break;
                }
                sb.append(s.charAt(idx));
                idx += (numRows - i) * 2;
                if (idx >= s.length()) {
                    break;
                }
                sb.append(s.charAt(idx));
                idx += (i - 1) * 2;
            }
        }
        // last row(row numRows)
        idx = numRows - 1;
        while (true) {
            if (idx >= s.length()) {
                break;
            }
            sb.append(s.charAt(idx));
            idx += 2 * (numRows - 1);
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        Algorithm_6_ZigZag_Conversion al = new Algorithm_6_ZigZag_Conversion();
        System.out.println(al.convert("PAYPALISHIRING", 3));
        System.out.println(al.convert("PAYPALISHIRING", 4));
        System.out.println(al.convert("AB", 1));
        System.out.println(al.convert("ABAB", 2));
        System.out.println(al.convert("A", 2));
        System.out.println(al.convert("A", 3));
    }
}
/*


1: 00008000000
2: 10079000000
3: 20600000000
4: 35001000000
5: 40002000000

 */