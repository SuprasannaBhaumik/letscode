package com.learn.interview.designPattern.chainOfResponsibility;

public class TestChain {

    public static void main(String[] args) {

        Chain chain1 = new PositiveOperation();
        Chain chain2 = new NegativeOperation();
        Chain chain3 = new MultiplyOperation();

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);

        Numbers numbers = new Numbers(4, 2, "add");

        chain1.calculate(numbers);

    }
}
