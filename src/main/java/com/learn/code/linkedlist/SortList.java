package com.learn.code.linkedlist;

public class SortList {
    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(6, five);
        ListNode three = new ListNode(9, four);
        ListNode two = new ListNode(8, three);
        ListNode one = new ListNode(-4, two);
        System.out.println(SortList.sortList(one));
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode firstPart = getMiddle(head);
        ListNode secondPart = firstPart.next;
        firstPart.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(secondPart);

        ListNode sortedList = combine(left, right);
        return sortedList;
    }

    //method to get the middle of the linked list
    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode combine(ListNode left, ListNode right) {
        ListNode result = null;

        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }

        if(left.val <= right.val) {
            result = left;
            result.next = combine(left.next, right);
        } else {
            result = right;
            result.next = combine(left, right.next);
        }
        return result;
    }
}
