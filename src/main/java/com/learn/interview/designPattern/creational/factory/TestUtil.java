package com.learn.interview.designPattern.creational.factory;

public class TestUtil {

    public static void main(String[] args) {
        Shape desiredShape = ShapeFactory.getShape("circle");
        desiredShape.draw();
    }
}
