package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href='https://leetcode.com/problems/swap-nodes-in-pairs/description/'>24. Swap Nodes in Pairs</a>
 */
public class Algorithm_24_Swap_Nodes_in_Pairs {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode root = new ListNode(0);
        ListNode cur = root;
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        while (true) {
            pointer1.next = pointer2.next;
            pointer2.next = pointer1;
            cur.next = pointer2;
            cur = cur.next.next;
            if (cur.next == null) {
                break;
            }
            pointer1 = cur.next;
            if (pointer1.next == null) {
                break;
            }
            pointer2 = pointer1.next;
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

    public static void main(String[] args) {
        Algorithm_24_Swap_Nodes_in_Pairs solution = new Algorithm_24_Swap_Nodes_in_Pairs();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(printNode(node1));
        ListNode ans = solution.swapPairs(node1);
        System.out.println(printNode(ans));
    }
}
