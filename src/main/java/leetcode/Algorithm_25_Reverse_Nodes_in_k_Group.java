package leetcode;

import java.util.Stack;

/**
 * <a href='https://leetcode.com/problemset/all/'>25. Reverse Nodes in k-Group  </a>
 */
public class Algorithm_25_Reverse_Nodes_in_k_Group {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(0);
        ListNode cur = head;
        root.next = cur;
        ListNode last = root;
        int i = 0;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            i++;
            stack.push(cur);
            if (i != k) {
                cur = cur.next;
                continue;
            }
            i = 0;
            ListNode next = cur.next;
            while (!stack.isEmpty()) {
                last.next = stack.pop();
                last = last.next;
            }
            last.next = next;
            cur = next;
        }
        return root.next;
    }


    private static StringBuilder printNode(ListNode node) {
        if (node == null) {
            return new StringBuilder().append("end");
        }
        if (node.next == null) {
            return new StringBuilder().append(node.val).append("->end");
        }
        return new StringBuilder().append(node.val).append("->").append(printNode(node.next));
    }

    private static ListNode[] genNodes(int n) {
        ListNode[] nodes = new ListNode[n + 1];
        nodes[0] = new ListNode(0);
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ListNode((int) (10 * i *  Math.sin(10 * i)));
            nodes[i - 1].next = nodes[i];
        }
        return nodes;
    }

    public static void main(String[] args) {
        ListNode[] nodes = genNodes(10);
        System.out.println(printNode(nodes[0]));


        Algorithm_25_Reverse_Nodes_in_k_Group solution = new Algorithm_25_Reverse_Nodes_in_k_Group();
        System.out.println(printNode(solution.reverseKGroup(nodes[0], 4)));
        System.out.println(printNode(solution.reverseKGroup(nodes[3], 4)));
    }
}
