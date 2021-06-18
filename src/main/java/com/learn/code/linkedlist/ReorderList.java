package com.learn.code.linkedlist;

/**
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ReorderList.reorderList(one);
    }

    public static ListNode reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedList = reverseList(slow.next);
        slow.next = null;
        while(head != null && reversedList != null) {
            ListNode firstNext = head.next;
            ListNode secondNext = reversedList.next;

            head.next = reversedList;
            reversedList.next = head.next;

            head = firstNext;
            reversedList = secondNext;

        }
        return head;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null) {
            next = current.next; //4
            current.next = prev; //null
            prev = current; //3
            current = next;
        }
        return prev;
    }
}
