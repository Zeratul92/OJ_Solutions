package leetcode;

/**
 * <a href='https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/'>19. Remove Nth Node From End of List</a>
 */
public class Algorithm_19_Remove_Nth_Node_From_End_of_List {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        if (n == cnt) {
            return head.next;
        }
        cur = head;
        int idx = 0;
        while (cur != null) {
            idx++;
            if (idx + n == cnt && cur.next != null) {
                cur.next = cur.next.next;
                return head;
            }
            cur = cur.next;
        }
        return null;
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
        Algorithm_19_Remove_Nth_Node_From_End_of_List s = new Algorithm_19_Remove_Nth_Node_From_End_of_List();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(printNode(node1));
        System.out.println(printNode(node3));
        System.out.println(printNode(s.removeNthFromEnd(node1, 1)));
//        System.out.println(printNode(s.removeNthFromEnd(node1, 2)));
//        System.out.println(printNode(s.removeNthFromEnd(node1, 3)));
//        System.out.println(printNode(s.removeNthFromEnd(node1, 4)));
//        System.out.println(printNode(s.removeNthFromEnd(node1, 5)));
    }
}
