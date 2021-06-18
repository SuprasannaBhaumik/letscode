package com.learn.code.linkedlist;

public class Remove_LL_Elements {

    public static void main(String[] args) {
        ListNode seven = new ListNode(6, null);
        ListNode six = new ListNode(1, null);
        ListNode five = new ListNode(1, six);
        ListNode four = new ListNode(2, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(4, three);
        ListNode one = new ListNode(5, two);
        Remove_LL_Elements.removeElements(one, 1);
        //Remove_LL_Elements.removeLastElement(one);

    }


    public static ListNode removeLastElement(ListNode head) {

        ListNode slow = head;
        ListNode prev = null;
        while (slow != null) {
            if(slow.next == null) {
                prev.next = null;
                break;
            }
            prev = slow;
            slow = slow.next;
        }
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode slow = head;
        ListNode prev = null;
        while (slow != null) {
            if (slow == head && slow.val == val) {
                head = head.next;
                slow = head;
                continue;
            }
            if(val == slow.val && slow.next != null) {
                slow = checkNextNodeSame(slow, val);
                prev.next = slow;
            } else if (val == slow.val){
                prev.next = null;
                break;
            }
            prev = slow;
            slow = slow != null ? slow.next : null;
        }
        return head;
    }

    private static ListNode checkNextNodeSame(ListNode slow, int val) {
        while(slow != null && val == slow.val) {
            slow = slow.next;
        }
        return slow;
    }
}
