package leetcode;

import java.util.HashSet;
import java.util.Set;

/*

 */
public class Algorithm_929_独特的电子邮件地址 {
    public int numUniqueEmails(String[] emails) {
        Set<String> ans = new HashSet<>();
        for (String email : emails) {
            String[] words = email.split("@");
            String temp = words[0].replaceAll("\\.", "");
            if (temp.contains("+")) {
                temp = temp.split("\\+")[0];
            }
//            System.out.println("-------------------------");
//            System.out.println(temp);
//            System.out.println(words[1]);
//            System.out.println("-------------------------");
            ans.add(temp + "@" + words[1]);
        }
        return ans.size();
    }

    public static void main(String[] args) {


        Algorithm_929_独特的电子邮件地址 s = new Algorithm_929_独特的电子邮件地址();
        System.out.println(s.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
        System.out.println(s.numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email@leetcode.com"}));


    }
}
