package com.learn.interview.designPattern.creational.abstractFactory;

public interface AbstractFactory<T> {

    public T create(String type);
}
