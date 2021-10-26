package leetcode;

/*

 */
public class Algorithm_717_1比特与2比特字符 {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1)
            i += bits[i] + 1;
        return i == bits.length - 1;
    }

    public static void main(String[] args) {


        Algorithm_717_1比特与2比特字符 s = new Algorithm_717_1比特与2比特字符();
        System.out.println(s.isOneBitCharacter(new int[]{1,0,0}));
        System.out.println(s.isOneBitCharacter(new int[]{1,1,1,0}));

    }
}
