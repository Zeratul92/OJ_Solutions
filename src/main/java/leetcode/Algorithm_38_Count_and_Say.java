package leetcode;

public class Algorithm_38_Count_and_Say {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String last = countAndSay(n - 1);
        char[] chars = last.toCharArray();
        char c = chars[0];
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == c) {
                cnt++;
                continue;
            }
            sb.append(cnt);
            sb.append(c);
            c = chars[i];
            cnt = 1;
        }
        sb.append(cnt);
        sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {

        Algorithm_38_Count_and_Say solution = new Algorithm_38_Count_and_Say();
        for (int n = 1; n < 30; n++) {
            System.out.println(n + ": " + solution.countAndSay(n));
        }
    }
}
