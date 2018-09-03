package leetcode;

public class Algorithm_67_Add_Binary {

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder ans = new StringBuilder();
        int temp = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            temp += x + y;
            ans = new StringBuilder(temp % 2 == 1 ? "1" : "0").append(ans);
            temp /= 2;
            i--;
            j--;
        }
        if (temp > 0) {
            ans = new StringBuilder("1").append(ans);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Algorithm_67_Add_Binary s = new Algorithm_67_Add_Binary();
        System.out.println(s.addBinary("101", "111"));
    }
}
