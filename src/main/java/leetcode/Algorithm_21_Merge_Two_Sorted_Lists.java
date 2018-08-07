package leetcode;

/**
 * <a href='https://leetcode.com/problems/merge-two-sorted-lists/description/'>21. Merge Two Sorted Lists</a>
 */
public class Algorithm_21_Merge_Two_Sorted_Lists {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode(0);
        ListNode node1 = l1, node2 = l2, cur = root;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
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
        Algorithm_21_Merge_Two_Sorted_Lists a = new Algorithm_21_Merge_Two_Sorted_Lists();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node0 = new ListNode(0);
        node0.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node7;

        node1.next = node5;
        node5.next = node8;

        System.out.println(printNode(node0));
        System.out.println(printNode(node1));
        System.out.println(printNode(a.mergeTwoLists(node0, node1)));

    }
}
