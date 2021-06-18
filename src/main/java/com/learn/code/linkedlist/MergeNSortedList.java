package com.learn.code.linkedlist;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeNSortedList {

    public static void main(String[] args) {

        ListNode x1_2 = new ListNode( 4,null);
        ListNode x1_1 = new ListNode( 3,x1_2);
        ListNode x1 = new ListNode( 2,x1_1);
        ListNode node1 = new ListNode(1, x1);

        ListNode x2_2 = new ListNode( 11, null);
        ListNode x2_1 = new ListNode( 7,x2_2);
        ListNode x2 = new ListNode( 5,x2_1);
        ListNode node2 = new ListNode(3, x2);

        ListNode x3_3 = new ListNode( 10,null);
        ListNode x3_2 = new ListNode( -1,x3_3);
        ListNode x3_1 = new ListNode( -3,x3_2);
        ListNode x3 = new ListNode( -5,x3_1);
        ListNode node3 = new ListNode(-9, x3);

        ListNode[] lists = new ListNode[]{node1, node2, node3};

        System.out.println(MergeNSortedList.mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        } else if(lists.length == 1) {
            return lists[0];
        } else if(lists.length == 0) {
            return null;
        }
        ListNode result = lists[0];
        for(int i=1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
