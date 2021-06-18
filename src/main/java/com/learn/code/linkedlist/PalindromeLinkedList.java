package com.learn.code.linkedlist;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode six1 = new ListNode(1);
        ListNode five1 = new ListNode(2, six1);
        ListNode four1 = new ListNode(3, five1);
        ListNode three1 = new ListNode(4, four1);
        ListNode two1 = new ListNode(5, three1);
        ListNode one1 = new ListNode(6, two1);
        ListNode six = new ListNode(6, one1);
        ListNode five = new ListNode(5, six);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        System.out.println(PalindromeLinkedList.isPalindrome(one));
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow != null ) {
            if(fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static int count(ListNode head) {
        int count = 1;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow != null) {
                count++;
            }
            if(fast != null) {
                count++;
            }
        }
        return count;
    }
}

