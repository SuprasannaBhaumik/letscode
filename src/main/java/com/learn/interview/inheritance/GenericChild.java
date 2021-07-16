package com.learn.interview.inheritance;

import java.util.HashMap;

public class GenericChild<T1, T2, T, A, B, C> extends GenericParent<T> implements GenericInterface<A, B, C> {

    T1 t1;
    T2 t2;

    GenericChild(T t) {
        super(t);
    }

    GenericChild(T t, T1 t1, T2 t2) {
        super(t);
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void printValues() {
        System.out.println();
    }


    public T2 getValue() {
        return t2;
    }


}
