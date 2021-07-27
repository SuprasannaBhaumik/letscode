package com.learn.interview.designPattern.creational.abstractFactory;

import com.learn.interview.designPattern.creational.abstractFactory.color.ColorFactory;
import com.learn.interview.designPattern.creational.abstractFactory.vehicle.VehicleFactory;
import com.learn.interview.designPattern.creational.factory.ShapeFactory;

public class FactoryProvider {

    public static AbstractFactory getFactoryByName(String name) {
        AbstractFactory factory;
        switch (name) {
            case "COLOR":
                factory = new ColorFactory();
                break;
            case "VEHICLE":
                factory = new VehicleFactory();
                break;
            default:
                factory = null;
                break;
        }
        return factory;
    }
}
