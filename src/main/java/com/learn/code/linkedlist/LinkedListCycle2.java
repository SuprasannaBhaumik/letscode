package com.learn.code.linkedlist;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle2 {

    public static void main(String[] args) {
        ListNode four = new ListNode(9);
        ListNode three = new ListNode(1, four);
        ListNode two = new ListNode(5, three);
        ListNode one = new ListNode(3, two);
        four.next = two;
        System.out.println(LinkedListCycle2.detectCycle(one));
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                ListNode newFast = head;
                while(newFast != slow) {
                    newFast = newFast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
