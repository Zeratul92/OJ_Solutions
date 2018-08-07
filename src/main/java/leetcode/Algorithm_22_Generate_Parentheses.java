package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href='https://leetcode.com/problems/generate-parentheses/description/'>22. Generate Parentheses</a>
 */
public class Algorithm_22_Generate_Parentheses {
    /*
    Use dfs to generate every possible result
     */
    private static class Node {
        // true if this is a '('
        boolean bool;
        Node left;
        Node right;

        Node(boolean bool) {
            this.bool = bool;
        }
    }

    private void gen(int n, int a, int b, Node parent) {
        if (a == n && a == b) {
            return;
        }
        if (a == n || b < a) {
            // add ')'
            parent.right = new Node(false);
            gen(n, a, b + 1, parent.right);
        }
        if (a < n) {
            // add '('
            parent.left = new Node(true);
            gen(n, a + 1, b, parent.left);
        }
    }

    private void dfs(int n, int level, Node node, List<String> list, char[] chars) {
        chars[level] = node.bool ? '(' : ')';
        if (level == 2 * n - 1) {
            // reach leave node, that is the end of the ans
            list.add(new String(chars));
            return;
        }
        if (node.left != null) {
            dfs(n, level + 1, node.left, list, chars);
        }
        if (node.right != null) {
            dfs(n, level + 1, node.right, list, chars);
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // Any answer always starts with '('
        Node root = new Node(true);
        gen(n, 1, 0, root);
        List<String> ans = new ArrayList<>();
        char[] chars = new char[2 * n];
        dfs(n, 0, root, ans, chars);

        return ans;
    }


    public static void main(String[] args) {
        Algorithm_22_Generate_Parentheses a = new Algorithm_22_Generate_Parentheses();
        for (int i = 1; i <= 10; i++) {
            List<String> list = a.generateParenthesis(i);
            System.out.println(i + ": " + list.size() + " " + list);
        }
    }
}
