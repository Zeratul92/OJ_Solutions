package leetcode;

/*

 */
public class Algorithm_917_仅仅反转字母 {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (i <= j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (i == j) {
                sb1.append(c1);
                break;
            }
            boolean b1 = Character.isAlphabetic(c1);
            boolean b2 = Character.isAlphabetic(c2);
            if (!b1) {
                sb1.append(c1);
                i++;
                continue;
            }
            if (!b2) {
                sb2.append(c2);
                j--;
                continue;
            }
            sb1.append(c2);
            sb2.append(c1);
            i++;
            j--;
        }
        return sb1.toString() + sb2.reverse().toString();
    }

    public static void main(String[] args) {


        Algorithm_917_仅仅反转字母 s = new Algorithm_917_仅仅反转字母();

        System.out.println(Character.isAlphabetic('a'));
        System.out.println(Character.isAlphabetic('~'));
        System.out.println(Character.isAlphabetic('-'));
        System.out.println(Character.isAlphabetic('F'));
        System.out.println(s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
