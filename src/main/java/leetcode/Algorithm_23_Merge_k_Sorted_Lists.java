package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href='https://leetcode.com/problems/merge-k-sorted-lists/description/'>23. Merge k Sorted Lists</a>
 */
public class Algorithm_23_Merge_k_Sorted_Lists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparing(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode root = new ListNode(0);
        ListNode cur = root;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
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
        Algorithm_23_Merge_k_Sorted_Lists solution = new Algorithm_23_Merge_k_Sorted_Lists();
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
        System.out.println(printNode(node1));

        node4.next = node5;
        node5.next = node6;
        System.out.println(printNode(node4));

        node7.next = node8;
        System.out.println(printNode(node7));

        ListNode[] nodes = {node1, node4, node7, null};


        ListNode ans = solution.mergeKLists(nodes);
        System.out.println(printNode(ans));
        System.out.println(printNode(node1));
    }
}
