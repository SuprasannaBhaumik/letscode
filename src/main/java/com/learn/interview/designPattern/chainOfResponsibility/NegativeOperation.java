package com.learn.interview.designPattern.chainOfResponsibility;

public class NegativeOperation implements Chain {

    Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if("sub".equalsIgnoreCase(request.getOperationName())) {
            System.out.println(request.getNumber1() - request.getNumber2());
        } else if(nextChain != null) {
            nextChain.calculate(request);
        }
    }
}
