package com.learn.code;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = -321;
        System.out.println(ReverseInteger.reverse(x));
    }

    public static int reverse(int x) {
        try {
            int toReverseNumber = Math.abs(x);
            StringBuilder sbf = new StringBuilder();
            while(toReverseNumber>0) {
                sbf.append(toReverseNumber%10);
                toReverseNumber = (int)toReverseNumber/10;
            }
            int number = Integer.parseInt(sbf.toString());
            if(x < 0) {
                number = -number;
            }
            return number;
        } catch (Exception e) {
            return 0;
        }
    }
}
