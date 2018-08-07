package leetcode;

/**
 * <a href='https://leetcode.com/problems/middle-of-the-linked-list/description/'>Middle of the Linked List</a>
 */
public class Algorithm_876_Middle_of_the_Linked_List {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        int mid = cnt / 2;
        cur = head;
        for (int i = 0; i < mid; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        Algorithm_876_Middle_of_the_Linked_List solution = new Algorithm_876_Middle_of_the_Linked_List();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(solution.middleNode(node1).val);
    }
}
