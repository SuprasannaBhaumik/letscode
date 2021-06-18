package com.learn.code.linkedlist;

public class LL_DetectCycle {

    public static void main(String[] args) {
        ListNode seven = new ListNode(7);
        ListNode six = new ListNode(6, seven);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        seven.next = three;
        LL_DetectCycle.detectCycle(one);
    }

    private static ListNode detectCycle(ListNode one) {



        return null;
    }
}
