package com.learn.interview.designPattern.creational.factory;

public class ShapeFactory {

    public static Shape getShape(String shapeName) {
        Shape desiredShape;
        switch (shapeName) {
            case "circle":
                desiredShape = new Circle();
                break;
            case "rectangle":
                desiredShape = new Rectangle();
                break;
            default:
                desiredShape = null;
                break;
        }
        return desiredShape;
    }
}
