package com.learn.basics;

public class Flight {
    private FlightNumber number;

    char myScore = 7;

    public Flight(FlightNumber number) {
        this.number = number;
    }


}

class FlightNumber {
    public int value;
    public String code;
}

