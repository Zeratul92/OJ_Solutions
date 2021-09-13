package leetcode;

/*

 */
public class Algorithm_522_最长特殊序列II {

    public boolean isSubSeq(String test, String model) {
        if (test.length() > model.length()) {
            return false;
        }
        int idx1 = 0, idx2 = 0;
        char testChar;
        char modelChar;
        while (idx1 < test.length() && idx2 < model.length()) {
            testChar = test.charAt(idx1);
            modelChar = model.charAt(idx2);
            if (testChar == modelChar) {
                idx1++;
                idx2++;
            } else {
                idx2++;
            }
        }
        return idx1 == test.length();
    }

    public int findLUSlength(String[] strs) {
        int ans = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubSeq(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Algorithm_522_最长特殊序列II solution = new Algorithm_522_最长特殊序列II();

        System.out.println(solution.isSubSeq("abc", "adc"));
        System.out.println(solution.isSubSeq("ac", "adc"));
        System.out.println(solution.isSubSeq("abc", "adcbac"));
        System.out.println(solution.findLUSlength(new String[]{"a", "ab", "abc", "abd", "abcd", "abcd"}));
    }
}
