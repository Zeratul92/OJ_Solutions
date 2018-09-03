package leetcode;

public class Algorithm_61_Rotate_List {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        if (size == 1) {
            return head;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        k = size - k;
        cur = head;
        ListNode pre = cur;
        for (int i = 0; i < k - 1; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode root = cur.next;
        pre = cur;
        pre.next = null;
        cur = root;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return root;
    }


    private static void printNode(ListNode node) {
        ListNode cur = node;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val).append(' ');
            cur = cur.next;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Algorithm_61_Rotate_List s = new Algorithm_61_Rotate_List();
        int n = 6;
        ListNode[] nodes = new ListNode[n];
        nodes[0] = new ListNode(0);
        for (int i = 1; i < n; i++) {
            nodes[i] = new ListNode(i);
            nodes[i - 1].next = nodes[i];
        }
        printNode(nodes[1]);


        ListNode node = s.rotateRight(nodes[1], 6);
        printNode(node);
    }
}
