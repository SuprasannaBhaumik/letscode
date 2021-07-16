package com.learn.basics;

public class Cougar implements HasTails {
    @Override
    public int getTailLength() {
        return 0;
    }

    public int getTailLength(int length) { return 2; }
}
