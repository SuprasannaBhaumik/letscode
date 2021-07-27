package com.learn.interview.designPattern.creational.abstractFactory.color;

import com.learn.interview.designPattern.creational.abstractFactory.AbstractFactory;

public class ColorFactory implements AbstractFactory<Color> {

    public Color create(String colorCode) {
        Color myColor;
        switch (colorCode) {
            case "RED":
                myColor = new Red();
                break;
            case "BLUE":
                myColor = new Blue();
                break;
            default:
                myColor = null;
                break;
        }
        return myColor;
    }
}
