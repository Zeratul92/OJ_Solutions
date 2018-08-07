package leetcode;

/**
 * <a href='https://leetcode.com/problems/add-two-numbers/description/'>Add Two Numbers</>
 */
public class Algorithm_2_Add_Two_Numbers {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode top = new ListNode(0);
        ListNode lastNode = top;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        while (cur1 != null || cur2 != null) {
            int val = carry;
            if (cur1 != null) {
                val += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                val += cur2.val;
                cur2 = cur2.next;
            }
            carry = val / 10;
            val = val % 10;
            lastNode.next = new ListNode(val);
            lastNode = lastNode.next;
        }
        if (carry > 0) {
            lastNode.next = new ListNode(carry);
        }

        return top.next;
    }
}
