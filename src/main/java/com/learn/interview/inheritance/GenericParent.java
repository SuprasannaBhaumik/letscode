package com.learn.interview.inheritance;

public class GenericParent<T> extends Parent{

    T t;

    GenericParent(T t) {
        this.t = t;
    }
}
