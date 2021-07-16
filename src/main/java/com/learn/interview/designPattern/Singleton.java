package com.learn.interview.designPattern;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {
        singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        if(singleton == null) {
            return new Singleton();
        } else {
            return singleton;
        }
    }
}
