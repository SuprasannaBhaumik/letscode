package com.learn.code.linkedlist;

public class RemoveDuplicatesFromSortedLinkedList {

    public static void main(String[] args) {
        ListNode seven = new ListNode(3, null);
        ListNode six = new ListNode(3, seven);
        ListNode five = new ListNode(3, six);
        ListNode four = new ListNode(2, five);
        ListNode three = new ListNode(2, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        RemoveDuplicatesFromSortedLinkedList.removeDuplicates(one);
    }

    private static ListNode removeDuplicates(ListNode head) {
        ListNode slow = head;
        while(slow != null && slow.next != null) {
            if(slow.val == slow.next.val) {
                slow.next = slow.next.next;
            } else {
                slow = slow.next;
            }
        }
        return head;
    }

}
