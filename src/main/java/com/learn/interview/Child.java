package com.learn.interview;

import com.learn.code.linkedlist.ListNode;

public class Child extends Parent{


    public static void main(String[] args) {

        ListNode ll5 = new ListNode(5);
        ListNode ll4 = new ListNode(4, ll5);
        ListNode ll3 = new ListNode(3, ll4);
        ListNode ll2 = new ListNode(2, ll3);
        ListNode ll1 = new ListNode(1, ll2);
        /*ListNode result = Oracle.replaceMiddleNode(ll1, 10);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        };*/

        Parent p = new Child();
        p.display();

    }


    public void display() {
        System.out.println("Child");
    }

    public static boolean isPalindrome(String s) {
        boolean result = true;
        char[] words = s.toCharArray();
        int length = words.length;
        int count = 0;
        while(count < length/2) {
            if(words[count] == words[length-1]) {
                count = count +1;
                length = length -1;
                continue;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }


    //replace with some other value
    public static ListNode replaceMiddleNode(ListNode head, int target) {
        ListNode fast = head, slow = head;
        //goto the middle node
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow has the middle node
        slow.setVal(target);
        return head;
    }

}
