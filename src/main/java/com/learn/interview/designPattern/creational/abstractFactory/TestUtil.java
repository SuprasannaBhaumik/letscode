package com.learn.interview.designPattern.creational.abstractFactory;

import com.learn.interview.designPattern.creational.abstractFactory.vehicle.Vehicle;

public class TestUtil {

    public static void main(String[] args) {
        AbstractFactory myFactory = FactoryProvider.getFactoryByName("VEHICLE");
        Vehicle vehicle = (Vehicle) myFactory.create("TRUCK");
        vehicle.vehicleCategory();

    }
}
