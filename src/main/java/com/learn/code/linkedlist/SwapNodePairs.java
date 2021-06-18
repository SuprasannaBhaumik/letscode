package com.learn.code.linkedlist;

public class SwapNodePairs {

    public static void main(String[] args) {
        ListNode four = new ListNode(9);
        ListNode three = new ListNode(1, four);
        ListNode two = new ListNode(5, three);
        ListNode one = new ListNode(3, two);

        SwapNodePairs.swapPairs(one);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }

}
