package com.learn.code;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(DivideTwoIntegers.divide(-2147483648, 4));
    }

    public static int divide(int dividend, int divisor) {
        long dividendRepr, divisorRepr = 0;
        boolean negative = false;
        double count = 0;
        if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            negative = false;
        } else {
            negative = true;
        }

        dividendRepr = dividend < 0 ? -(long)dividend : dividend;
        divisorRepr = divisor < 0 ? -(long)divisor : divisor;

        if ( dividendRepr == divisorRepr) {
            if(negative) {
                return -1;
            } else {
                return 1;
            }
        } else if(divisorRepr == 1 && dividendRepr != 0) {
            if (negative){
                return (int)(-1 * dividendRepr);
            } else {
                // convert to Long
                Long longDividend = dividendRepr;
                Long value = new Long("2147483648");
                if(longDividend.equals(value)) {
                    return (int)(Math.pow(2, 31) - 1);
                } else {
                    return (int)dividendRepr;
                }
            }
        } else if( dividendRepr == 0){
            return 0;
        }

        if(divisorRepr > dividendRepr) {
            return 0;
        }
        while(dividendRepr >= divisorRepr) {
            dividendRepr = Math.subtractExact(dividendRepr, divisorRepr);
            count++;
        }
        return negative ? -1 * (int)Math.round(count): (int)Math.round(count);
    }
}
