package leetcode;

/*

 */
public class Algorithm_657_机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
        int len = moves.length();
        int x = 0, y = 0;
        for (int i = 0; i < len; i++) {
            char c = moves.charAt(i);
            if (c == 'R') x++;
            if (c == 'L') x--;
            if (c == 'U') y++;
            if (c == 'D') y--;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {


        Algorithm_657_机器人能否返回原点 s = new Algorithm_657_机器人能否返回原点();
        System.out.println(s.judgeCircle(""));


    }
}
