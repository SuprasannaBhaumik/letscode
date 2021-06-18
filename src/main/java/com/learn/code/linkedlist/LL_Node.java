package com.learn.code.linkedlist;

public class LL_Node {

    int val;

    LL_Node next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LL_Node getNext() {
        return next;
    }

    public void setNext(LL_Node next) {
        this.next = next;
    }

    LL_Node() {}

    LL_Node(int val) {
        this.val = val;
    }

    LL_Node(int val, LL_Node next) {
        this.val = val;
        this.next = next;
    }
}
