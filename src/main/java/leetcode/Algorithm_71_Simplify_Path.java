package leetcode;

import java.util.Stack;

public class Algorithm_71_Simplify_Path {

    public String simplifyPath(String path) {
        String[] dirs = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (dir.equals(".")) {
                continue;
            }
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(dir);
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append('/').append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Algorithm_71_Simplify_Path s = new Algorithm_71_Simplify_Path();
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
        System.out.println(s.simplifyPath("/.."));
    }
}
