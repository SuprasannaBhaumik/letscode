package com.learn.code;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedList {

    public static void main(String[] args) {

        ListNode five_r = new ListNode(9);
        ListNode five_ee = new ListNode(8, five_r);
        ListNode five_ = new ListNode(7, five_ee);
        ListNode four = new ListNode(0, five_);
        ListNode three = new ListNode(-4, four);
        ListNode two = new ListNode(-7, three);
        ListNode one = new ListNode(-8, two);

        ListNode five_2 = new ListNode(-3, null);

        MergeSortedList.mergeTwoLists(one, five_2);

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> resultList = new ArrayList<>();
        int i=0;

        if(l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null){
            return l1;
        }

        while(l1 != null || l2 != null) {
            int first = l1 != null ? l1.val: 0;
            int second = l2 != null ? l2.val: 0;
            if (first > second && l2 != null) {
                resultList.add(second);
                l2 = l2.next;
            } else if (first == second) {
                if(l1!=null) {
                    l1 = l1.next;
                    resultList.add(second);
                }
                if(l2!=null) {
                    l2 = l2.next;
                    resultList.add(second);
                }
            } else if (second > first && l1 != null){
                resultList.add(first);
                l1 = l1.next;
            } else {
                resultList.add(first != 0 ? first : second);
                if(first != 0) {
                    l1 = l1.next;
                } else {
                    l2 = l2.next;
                }
            }
            i++;
        }
        ListNode node = new ListNode();
        for ( int k = resultList.size() - 1; k >= 0;  k--) {
            if ( k == resultList.size() - 1) {
                node.val = resultList.get(k);
                node.next = null;
            } else {
                ListNode newNode = new ListNode(resultList.get(k), node);
                node = newNode;
            }
        }
        return node;
    }


}
