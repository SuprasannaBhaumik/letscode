package com.learn.interview.designPattern.chainOfResponsibility;

public class Numbers {

    private int number1;
    private int number2;
    private String operationName;

    public Numbers(int number1, int number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operationName = operation;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperationName() {
        return operationName;
    }

}
