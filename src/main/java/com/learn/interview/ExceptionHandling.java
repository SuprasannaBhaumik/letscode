package com.learn.interview;

public class ExceptionHandling {

    public static void main(String[] args) {
        System.out.println(ExceptionHandling.result());
    }

    public static int result() {
        try{
            //throw new Exception("hello world");
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.println("inside finally");
            return 3;
        }
    }
}
