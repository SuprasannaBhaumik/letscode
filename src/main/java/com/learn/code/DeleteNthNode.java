package com.learn.code;

import java.util.HashMap;

public class DeleteNthNode {

    public static void main(String[] args) {

        ListNode four = new ListNode(9);
        ListNode three = new ListNode(1);
        ListNode two = new ListNode(5);
        ListNode one = new ListNode(3);
        one.next = two;
        two.next = three;
        three.next = four;

        System.out.println(DeleteNthNode.removeNthFromEnd(one, 2));

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode forCount = head;
        HashMap<Integer, ListNode> nodeMap = new HashMap<>();
        while (forCount != null) {
            nodeMap.put(count, forCount);
            count++;
            forCount = forCount.next;
        }
        count--;

        if(count == 1 && n == 1) {
            return null;
        }
        int target = (count+1) -n; // 3, 5, 1, 9 -> 2
        if(nodeMap.containsKey(target) && n != count) {
            ListNode currentNode = nodeMap.get(target);
            ListNode prevNode = nodeMap.get(target-1);
            ListNode nextNode = nodeMap.get(target+1);
            prevNode.next = nextNode;
            nodeMap.remove(target);

        } else if (count == n && count > 1) {
            ListNode currentNode = nodeMap.get(target);
            currentNode.next = null;
            return nodeMap.get(target + 1);
        }else {
            ListNode firstNode = nodeMap.get(target);
            firstNode.next = null;
        }
        return nodeMap.get(1);
    }
}
