package leetcode;

import java.util.HashMap;
import java.util.Map;

/*

 */
public class Algorithm_541_反转字符串II {

    public String reverseStr(String s, int k) {
        int len = s.length();
        StringBuffer sb = new StringBuffer(len);
        for (int i = 0; i < len; i += k << 1) {
            int j = Math.min(i + k, len);
            sb.append(new StringBuffer(s.substring(i, j)).reverse());
            if (i + k < len) {
                sb.append(s.substring(i + k, Math.min(i + 2 * k, len)));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println("hehe".substring(0, 1));
        System.out.println("hehe".substring(0, 0));

        Algorithm_541_反转字符串II solution = new Algorithm_541_反转字符串II();

        System.out.println(solution.reverseStr("abcdefgh", 3));

    }
}
