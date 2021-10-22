package leetcode;

/*

 */
public class Algorithm_925_长按键入 {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        int i = 0, j = 0;
        char last = 0;
        while (i < len1 && j < len2) {
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if (c1 == c2) {
                i++;
                j++;
                last = c1;
            } else {
                if (last != c2) return false;
                j++;
            }
        }
        if (i < len1) return false;

        while (j < len2) {
            if (last != typed.charAt(j)) return false;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {


        Algorithm_925_长按键入 s = new Algorithm_925_长按键入();
        System.out.println(s.isLongPressedName("leelee", "lleeelee"));
        System.out.println(s.isLongPressedName("saeed", "ssaaedd"));

    }
}
