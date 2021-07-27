package com.learn.interview.designPattern.creational.abstractFactory.vehicle;

import com.learn.interview.designPattern.creational.abstractFactory.AbstractFactory;

public class VehicleFactory implements AbstractFactory<Vehicle> {

    public Vehicle create(String vehicleCategory) {
        Vehicle myVehicle;
        switch (vehicleCategory) {
            case "TRUCK":
                myVehicle = new Truck();
                break;
            case "CAR":
                myVehicle = new Car();
                break;
            default:
                myVehicle = null;
                break;
        }
        return myVehicle;
    }
}
