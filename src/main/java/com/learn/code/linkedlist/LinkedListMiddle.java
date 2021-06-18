package com.learn.code.linkedlist;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class LinkedListMiddle {

    public static void main(String[] args) {
        ListNode six = new ListNode(6);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        System.out.println(LinkedListMiddle.middleNode(one));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null || fast.next == null) {
                return slow;
            }
        }
        return slow;
    }
}
