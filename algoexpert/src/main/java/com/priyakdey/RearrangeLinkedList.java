package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RearrangeLinkedList {

    // https://www.algoexpert.io/questions/rearrange-linked-list
    //
    // NOTES:
    // Iterate over the list and create 3 separate lists - one less than, one eq to and
    // another one gt than.
    // Then conditionally join them back.

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedList head1 = new LinkedList(-1);
        LinkedList head2 = new LinkedList(-1);
        LinkedList head3 = new LinkedList(-1);

        LinkedList curr = head;

        LinkedList curr1 = head1;
        LinkedList curr2 = head2;
        LinkedList curr3 = head3;


        while (curr != null) {
            if (curr.value < k) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else if (curr.value == k) {
                curr2.next = curr;
                curr2 = curr2.next;
            } else {
                curr3.next = curr;
                curr3 = curr3.next;
            }
            curr = curr.next;
        }

        curr1.next = null;
        curr2.next = null;
        curr3.next = null;

        if (head1.next != null) {
            if (head2.next != null) {
                curr1.next = head2.next;
                curr2.next = head3.next;
            } else {
                curr1.next = head3.next;
            }
            return head1.next;
        }

        if (head2.next != null) {
            curr2.next = head3.next;
            return head2.next;
        }

        return head3.next;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

}
