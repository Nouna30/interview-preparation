package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class P2 {

    // #2. https://leetcode.com/problems/add-two-numbers/description
    //
    // NOTES:
    // Take two pointers and iterate over each list adding the value.
    // Like the classic merge two sorted linked list.
    // Add the end check if carry is still 1, and add another node if.
    //
    // Time complexity: O(n) Space Complexity: O(n) - no auxiliary extra space

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        int carry = 0;

        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            int value = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(value);
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while (curr1 != null) {
            int sum = curr1.val + carry;
            int value = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(value);
            curr = curr.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            int sum = curr2.val + carry;
            int value = sum % 10;
            carry = sum / 10;
            curr.next = new ListNode(value);
            curr = curr.next;
            curr2 = curr2.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
